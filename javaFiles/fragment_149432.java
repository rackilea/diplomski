// records start and end times for complete two directions itinerary
public class RecordedItinerary {

    public RecordedTrack AtoB;
    public RecordedTrack BtoA;

    public RecordedItinerary (RecordedTrack AtoB, RecordedTrack BtoA) {
        this.AtoB = AtoB;
        this.BtoA = BtoA;
    }
}