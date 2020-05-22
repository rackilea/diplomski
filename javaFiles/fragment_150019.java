[...]
JobDetail jobDetail = newJob(SchedulingCalculationJob.class)
        .withIdentity("SchedulingCalculation_CalendarIntervaled", "calendarIntervaled")
        .build();

CalendarIntervalTrigger calendarIntervalTrigger = newTrigger()
        .withIdentity("calendarIntervalCalculationTrigger", "calendarIntervaled")
        .withSchedule(calendarIntervalSchedule()
                .withIntervalInMonths(2))
        .startAt(decemberFirst.getTime())
        .forJob(jobDetail)
        .build();

scheduler.scheduleJob(jobDetail, calendarIntervalTrigger);