public TimeSchedule clone() {
    TimeSchedule copy = new TimeSchedule();
    for (int i = 0; i < timetable.length; i++) {
        copy.timetable[i] = timetable[i].clone();
    }
    return copy;
}