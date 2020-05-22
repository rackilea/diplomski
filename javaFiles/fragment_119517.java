public class EventManager implements PathListener {
    private int managerLocation;
    private ArrayList<Event> events;
    public EventManager() {
        events = new ArrayList<Event>();
    }
    public void addEvent(Event e) {
        e.addPathListener(this);
        events.add(e);
    }

    @Override
    public notifyLocation(int location) { //Of the PathListener interface
        managerLocation = location;
    }
}