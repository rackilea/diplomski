ArrayList<ScheduleEntries> times = new ArrayList<>();

times.add(new ScheduleEntries(LocalTime.of(8, 00), LocalTime.of(12, 00)));
times.add(new ScheduleEntries(LocalTime.of(11, 00), LocalTime.of(15, 00)));
times.add(new ScheduleEntries(LocalTime.of(9, 00), LocalTime.of(17, 00)));

LocalTime minStart = times.get(0).getStart();
LocalTime maxStop = times.get(0).getStop();

for (ScheduleEntries time : times) {
    if (time.getStart().isBefore(minStart)) {
        minStart = time.getStart();
    }
    if (time.getStop().isAfter(maxStop)) {
        maxStop = time.getStop();
    }
}