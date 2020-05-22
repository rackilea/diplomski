Duration total = Duration.ZERO;
for (...) {
    LocalTime curStart = ...
    LocalTime curEnd = ...
    LocalTime nextStart = ...
    LocalTime nextEnd = ...

    if (total.toMillis() == 0) {
        duration = dts.getDuration();
    }
    if (curStart.equals(nextStart) && curEnd.isBefore(nextEnd)) {
        total = total.plus(Duration.between(curEnd, nextEnd));
    } else if (nextStart.isAfter(curEnd)) {
        total = total.plus(downTimes.get(i).getDuration());
    } else if (curStart.isBefore(nextStart) && curEnd.isAfter(nextStart)) {
        total = total.plus(Duration.between(curEnd, nextEnd));
    } else if (curEnd.equals(nextStart)) {
        total = total.plus(downTimes.get(i).getDuration());
    }
    i++;
    if (i == downTimes.size()) {
        // assuming you want the duration as a total of milliseconds
        componentDTimeMap.put(application, total.toMillis());
        return;
    }
}