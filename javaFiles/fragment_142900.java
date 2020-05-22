if (scheduleEndDay < scheduleStartDay) {
    scheduleEndDay += DaysToNo.size();
}

if (currentDayInNo <  scheduleStartDay) {
    currentDayInNo += DaysToNo.size();
}