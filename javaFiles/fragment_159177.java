final MutablePicoContainer container = new PicoBuilder()
        .withBehaviors(new JobEnabledDecorating())
        .build();

    container.addComponent(Job.class, MyJob.class);

    final Job job = container.getComponent(Job.class);
    job.execute();