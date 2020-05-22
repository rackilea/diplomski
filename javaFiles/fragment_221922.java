@Entity
@Table(name = "SegmentOrigin")
public class SegmentOrigin implements Comparable<SegmentOrigin>{

    @JsonProperty("idSegment")
    private String idSegment;

    public int compareTo(SegmentOrigin arg0) {
        return this.getIdSegment().compareTo(arg0.getIdSegment()); // Check nullity if needed
    }
}