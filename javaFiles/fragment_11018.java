private ScheduleExpression parseCronExpressionToScheduleExpression(String cronExpression) {

    if ("never".equals(cronExpression)) {
        return null;
    }

    // parsing it more or less like cron does, at least supporting same fields (+ seconds)

    final String[] parts = cronExpression.split(" ");
    final ScheduleExpression scheduleExpression;

    if (parts.length != 6 && parts.length != 5) {
        scheduleExpression = scheduleAliases.get(cronExpression);
        if (scheduleExpression == null) {
            throw new IllegalArgumentException(cronExpression + " doesn't have 5 or 6 segments as excepted");
        }
        return scheduleExpression;
    } else if (parts.length == 6) { // enriched cron with seconds
        return new ScheduleExpression()
                .second(parts[0])
                .minute(parts[1])
                .hour(parts[2])
                .dayOfMonth(parts[3])
                .month(parts[4])
                .dayOfWeek(parts[5]);
    }

    // cron
    return new ScheduleExpression()
            .minute(parts[0])
            .hour(parts[1])
            .dayOfMonth(parts[2])
            .month(parts[3])
            .dayOfWeek(parts[4]);
}