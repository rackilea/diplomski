/** @return a list of 0, 1 or 2 schedules with the dates from this schedule that are not in other */
List<Schedule> notPresentIn(Schedule other) {
    if (other.end.isBefore(start) || end.isBefore(other.start)) { // no overlap
        return Collections.singletonList(this);
    }
    // now we know there is an overlap
    List<Schedule> result = new ArrayList<>(2);
    if (start.isBefore(other.start)) { // need to include day/s from the first part of this
        // this bit must end the day before other.start
        result.add(new Schedule(objectiveId, start, other.start.minusDays(1)));
    }
    if (end.isAfter(other.end)) { // need day/s from the last part
        result.add(new Schedule(objectiveId, other.end.plusDays(1), end));
    }
    return result;
}