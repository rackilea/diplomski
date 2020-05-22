try {
        SingleTask = Class.forName("domain.SingleTask");
        RepeatingTask = Class.forName("domain.RepeatingTask");
        ComplexTask = Class.forName("domain.ComplexTask");
        mappers.put(SingleTask, new SingleTaskRDBMapper());
        mappers.put(RepeatingTask, new RepeatingTaskRDBMapper());
        mappers.put(ComplexTask, new ComplexTaskRDBMapper());
    }
    catch (ClassNotFoundException e) {
        log.warn("Cannot load class", e);
    }