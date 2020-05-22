public static R createHiddenTextRun(String data) {
        R run=factory.createR();
        RPr runProperties = new RPr();
        BooleanDefaultTrue booleanDefaultTrue = new BooleanDefaultTrue();
        runProperties.setVanish(booleanDefaultTrue);
        run.setRPr(runProperties);
        run.getContent().add(data);
        return run;
    }