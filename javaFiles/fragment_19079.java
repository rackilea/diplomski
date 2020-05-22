Calendar firstDayOfMonth = Calendar.getInstance();
firstDayOfMonth.set(Calendar.MILLISECOND, 0);
firstDayOfMonth.set(Calendar.SECOND, 0);
firstDayOfMonth.set(Calendar.MINUTE, 0);
firstDayOfMonth.set(Calendar.HOUR, 0);
firstDayOfMonth.set(Calendar.DAY_OF_MONTH,
    Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));

Calendar lastDayOfMonth = Calendar.getInstance();
lastDayOfMonth.set(Calendar.MILLISECOND, 0);
lastDayOfMonth.set(Calendar.SECOND, 0);
lastDayOfMonth.set(Calendar.MINUTE, 0);
lastDayOfMonth.set(Calendar.HOUR, 0);
lastDayOfMonth.set(Calendar.DAY_OF_MONTH,
    Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));

int nbDays = getWorkingDaysBetweenTwoDates(firstDayOfMonth.getTime(),
    lastDayOfMonth.getTime());