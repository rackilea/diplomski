class Adapter {

    Processor getProcessor(Object o) {
        if (o instance of A) {
            return new ProcessorA();
        } else if ...
    }

}