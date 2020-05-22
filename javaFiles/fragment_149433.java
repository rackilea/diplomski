// records weekly itineraries of one person 
public class Person {

    public String name;
    public RecordedItinerary[] weeklyItineraries = new RecordedItinerary[DayOfWeek.values().length+1]; 

    public Person (String name) {
        this.name = name;
    }

    // add an itinerary of given day-of-week
    public void addDailyItinerary(DayOfWeek dow, RecordedItinerary itinerary) {
        weeklyItineraries[dow.getValue()] = itinerary;
    }
    // add today's itinerary
    public void addDailyItinerary(RecordedItinerary itinerary) {
        addDailyItinerary(LocalDateTime.now().getDayOfWeek(), itinerary);
    }

    // get an itinerary of given day-of-week 
    public RecordedItinerary getDailyItinerary(DayOfWeek dow) {
        return weeklyItineraries[dow.getValue()];
    }
    // get today's itinerary
    public RecordedItinerary getDailyItinerary() {
        return getDailyItinerary(LocalDateTime.now().getDayOfWeek());
    }

    // a person is identified by his/her name
    // will throw ClassCastException if arg is not a Person
    @Override
    public boolean equals(Object o) {
        return this.name.equals(((Person)o).name);
    }
}