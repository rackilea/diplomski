try {
        SingleTask = Class.forName("SingleTask");
        RepeatingTask = Class.forName("RepeatingTask");
        ComplexTask = Class.forName("ComplexTask");
        mappers.put(SingleTask, new SingleTaskRDBMapper());
        mappers.put(RepeatingTask, new RepeatingTaskRDBMapper());
        mappers.put(ComplexTask, new ComplexTaskRDBMapper());
    }
    catch (ClassNotFoundException e) {}