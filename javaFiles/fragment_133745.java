Iterator<HashMap.Entry<String, TimerHolder>> iterator = mTimers.entrySet().iterator();
while (iterator.hasNext()) {
    HashMap.Entry<String, TimerHolder> entry = iterator.next();
    if (!entry.getValue().isValid()) {
       iterator.remove();
    }
}