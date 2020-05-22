public class SchedulingCalculationJob implements Job {

    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        Calendar calendar = calculateJobFiringDate();

        // Create and schedule a dedicated trigger
        Trigger calculateFiring = calculateFiring = newTrigger()
               .withSchedule(SimpleSchedulerBuilder.simpleScheduler())
               .startAt(calendar.getTime())
               .forJob(yourRealJobDetail)
               .build();

        scheduler.scheduleJob(yourRealJobDetail, calculateFiring);
    }

    public static Calendar calculateJobFiringDate() {
        Calendar result = Calendar.getInstance();

        // Set up the scheduling day
        if (isThereThirtyDaysInCurrentMonth()) {
            // the 30th of the current month
            calendar.set(Calendar.DAY_OF_MONTH, 30);
        } else {
            // the last day of the current month
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DATE, -1);
        }

        // Set up time of day
        calendar.set(Calendar.HOUR, ...);
        calendar.set(Calendar.MINUTE, ...);
        calendar.set(Calendar.SECOND, ...);

        return result;
    }

    public static boolean isThereThirtyDaysInCurrentMonth() {
        Calendar thirtydaysInCurrentMonthCalendar = Calendar.getInstance();

        Integer currentMonth = thirtydaysInCurrentMonthCalendar.get(Calendar.MONTH);
        thirtydaysInCurrentMonthCalendar.add(Calendar.DATE, 29);

        return (currentMonth == thirtydaysInCurrentMonthCalendar.get(Calendar.MONTH);
    }
}