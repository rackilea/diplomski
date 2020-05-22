Arrays.sort(eventStuff, new Comparator<Event>() {
    @Override
    public int compare(Event o1, Event o2) 
    {
        if (o1.getEventStr() < o2.getEventStr())
            return -1;
        else if (o1.getEventStr() == o2.getEventStr()) // this line
            return 0;
        else
            return 1;
    }                                   
});