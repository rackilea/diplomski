@Override
public boolean isTimeIncluded(long timeStamp) {
    if (super.isTimeIncluded(timeStamp) == false) {
        return false;
    }

    Date lookFor = getStartOfDayJavaCalendar(timeStamp).getTime();

    return dates.contains(lookFor); // <-- HERE we remove the bang (!)
}