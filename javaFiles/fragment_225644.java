SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();
quartzScheduler.setSchedulerName("rm-quartz-scheduler");

Properties props = new Properties();

// Thread pooling
props.put("org.quartz.threadPool.class", org.quartz.simpl.SimpleThreadPool.class.getName());
props.put("org.quartz.threadPool.threadCount", "200");
props.put("org.quartz.threadPool.threadPriority", "5");

quartzScheduler.setQuartzProperties(props);