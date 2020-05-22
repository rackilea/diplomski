from("jms:in")
             .to("seda:seda1");

             from("seda:sead1?concurrentConsumers=10")
             .process(new CustomProcessor())
             .to("jms:out");