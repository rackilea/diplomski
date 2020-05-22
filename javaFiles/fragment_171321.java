public float getAverageTraffic(EventTimeStamp startDate, int durationHours)
{
    EventTimeStamp startEventTS = startDate.subtract(0,durationHours);
    CarEvent startEvent = eventList.get(startEventTS); //there might not be an event at exactly this point. So some tolerance have to be built in to this.
    CarEvent endEvent = eventList.get(startDate);
    return getAverage(startEvent,endEvent);//the two params are part of a linked list, so you can iterate and compute the average.
}