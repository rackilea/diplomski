public static List<Schedule> scheduleListDiff(
        List<Schedule> schedules, List<Schedule> schedulesToExclude) {
    // eliminate dates from schedulesToExclude one schdule at a time
    for (Schedule toExclude : schedulesToExclude) {
        List<Schedule> result = new ArrayList<>();
        for (Schedule originalSchedule : schedules) {
            result.addAll(originalSchedule.notPresentIn(toExclude));
        }
        schedules = result;
    }
    return schedules;
}