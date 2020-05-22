public class Test {

    public void call() {
        MyClass myClass = new MyClass();

        myClass.methodTwo(f-> {
            if (f.succeeded()) {
                //do something with f.result()
            }
            else {
                //handle;
            }
        });
    }
}

public class MyClass {

    public methodTwo(Handler<AsyncResult<String>> handler) {
        KafkaProducerRecord<String, String> record = KafkaProducerRecord.create(...);

        //response.complete("initial value");

        kafkaProducer.write(record, done -> {
            if(done.succeeded()) {
                handler.handle("done");
            }
            else {
                handler.handle("not done");
            };
        );

        //return response;
    }
}