@Transient
private ArrayList<Date> startTimes = new ArrayList<>();
//Remove all other annotations

@Transient
public List<Date> getStartTimes () {
    return workTimes.map(workTime -> workTime.getStartTime()).collect(Collection::toList);
}