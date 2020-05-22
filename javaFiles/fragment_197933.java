@XmlRootElement(name = "TAF")
public class Taf {
    @XmlElement(name = "raw_text") private String raw_text;
    @XmlElement(name = "station_id") private String station_id; // ICAO
    @XmlElement(name = "issue_time") private Date issue_time;
    @XmlElement(name = "bulletin_time") private Date bulletin_time;
    @XmlElement(name = "valid_time_from") private Date valid_time_from;
    @XmlElement(name = "valid_time_to") private Date valid_time_to;
    @XmlElement(name = "remarks") private String remarks;
    @XmlElement(name = "latitude") private Double latitude;
    @XmlElement(name = "longitude") private Double longitude;
    @XmlElement(name = "elevation_m") private Double elevation_m;
    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "forecast") private List<Forecast> forecast;
    // getters and setters
}