public class RecordingTimesSystem {

    public static void main(String... args) {
        // new person!
        Person john = new Person("John Doe");
        // add today's two-direction itinerary 
        john.addDailyItinerary(
            new RecordedItinerary(
                new RecordedTrack("07:10:00", "07:20:30"), // a-to-b recorded times
                new RecordedTrack("09:30:00", "09:37:00")) // b-to-a recorded times
        );

        DayOfWeek requestedDayOfWeek = LocalDateTime.now().getDayOfWeek();
        System.out.println(john.name + " " + requestedDayOfWeek.toString() + 
                " AtoB: " + 
                john.getDailyItinerary().AtoB.getDuration().getSeconds() + " (sec) " +  
                john.getDailyItinerary().AtoB.getDurationStr() + " (mm:ss)");
        System.out.println(john.name + " " + requestedDayOfWeek.toString() + 
                " BtoA: " + 
                john.getDailyItinerary().BtoA.getDuration().getSeconds() + " (sec) " +  
                john.getDailyItinerary().BtoA.getDurationStr() + " (mm:ss)");
    }
}