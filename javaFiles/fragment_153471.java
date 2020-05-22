Arrays.sort(eventStuff, new Comparator<Event>() {
    @Override
    public int compare(final Event o1, final Event o2) {
        return o1.getEventStr().compareTo(o2.getEventStr));
    }                                   
});