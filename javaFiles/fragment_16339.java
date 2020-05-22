from("file:work/customer/").id("customerDataRoute")
        .onCompletion().log("Customer data  processing finished").end()
        .log("Processing customer data ${file:name}")
        .split(body().tokenize("\n")).streaming() //no more parallel processing
        .choice()
            .when(simple("${body} contains 'HEADER TEXT'")) //strip out the header if it exists
            .log("Skipping first line")
            .endChoice()
        .otherwise()
            .to("seda:processCustomer?size=40&concurrentConsumers=20&blockWhenFull=true")
            .endChoice();


from("seda:processCustomer?size=40&concurrentConsumers=20&blockWhenFull=true")
            .unmarshal(bindyCustomer)
            .split(body())
            .process(new CustomerProcessor()).id("CustomProcessor") //converts one Notification into an array of values for the SQL insert
.to("sql:INSERT INTO CUSTOMER_DATA(`FIELD1`,`FIELD2`) VALUES(#,#)");