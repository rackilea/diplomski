public static void main(String[] args) {
    ArrayList<ScheduleEntries> times = new ArrayList<>();
    ArrayList<ScheduleEntries> mergedTimes = new ArrayList<>();

    times.add(new ScheduleEntries(LocalTime.of(8, 00), LocalTime.of(12, 00)));
    times.add(new ScheduleEntries(LocalTime.of(11, 00), LocalTime.of(15, 00)));
    times.add(new ScheduleEntries(LocalTime.of(9, 00), LocalTime.of(17, 00)));
    times.add(new ScheduleEntries(LocalTime.of(18, 00), LocalTime.of(20, 00)));
    times.add(new ScheduleEntries(LocalTime.of(18, 00), LocalTime.of(21, 00)));

    // Add all the times in a list
    ArrayList<Time> allTimes = new ArrayList<>();
    times.forEach(time -> {
        allTimes.add(new Time(time.getStart(), "start"));
        allTimes.add(new Time(time.getStop(), "stop"));
    });

    // Sort the list, I used a bubblesort
    boolean sorted = false;
    LocalTime tempTime;
    String tempString;
    while (!sorted) {
        sorted = true;
        for (int i = 0; i < allTimes.size() - 1; i++) {
            if (allTimes.get(i).getTime().isAfter(allTimes.get(i + 1).getTime())) {
                tempTime = allTimes.get(i + 1).getTime();
                tempString = allTimes.get(i + 1).getStartOrStop();

                allTimes.get(i + 1).setTime(allTimes.get(i).getTime());
                allTimes.get(i + 1).setStartOrStop(allTimes.get(i).getStartOrStop());

                allTimes.get(i).setTime(tempTime);
                allTimes.get(i).setStartOrStop(tempString);
                sorted = false;
            }
        }
    }

    // Only keep the relevant times
    LocalTime tempstart;
    int i = 0;
    while (i < allTimes.size()) {
        tempstart = allTimes.get(i).getTime();
        // iterate till you find a stop
        while (allTimes.get(i).getStartOrStop().equals("start")) {
            i++;
        }
        // iterate till you find a start, incase there's several stops in a row
        while (i < allTimes.size() && allTimes.get(i).getStartOrStop().equals("stop")) {
            i++;
        }
        mergedTimes.add(new ScheduleEntries(tempstart, allTimes.get(i - 1).getTime()));
    }

    // Print to check
    mergedTimes.forEach(time -> {
        System.out.println("Start: " + time.getStart() + ", Stop: " + time.getStop());
    });
}

// The class I made to hold the time and wether it's a start or a stop.
static class Time {
    private LocalTime time;
    private String startOrStop;
    public Time(LocalTime time, String startOrStop) {
        this.time = time;
        this.startOrStop = startOrStop;
    }
    // Getter and setter
    public String getStartOrStop() { return startOrStop; }
    public void setStartOrStop(String startOrStop) { this.startOrStop = startOrStop; }
    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
}