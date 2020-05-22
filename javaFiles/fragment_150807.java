LocalDateTime ldt = LocalDateTime.of(
    reminder.getReminderYear(),
    reminder.getReminderMonth() + 1,  // Add one to adjust from zero-based counting.
    reminder.getReminderDayofMonth(),
    reminder.getReminderHour(),
    reminder.getReminderMinute()
);