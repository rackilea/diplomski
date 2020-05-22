@XmlRootElement(name = "forecast")
public class Forecast {
    @XmlElement(name = "fcst_time_from") private Date fcst_time_from;
    @XmlElement(name = "fcst_time_to") private Date fcst_time_to;
    @XmlElement(name = "wind_dir_degrees") private Integer wind_dir_degrees;
    @XmlElement(name = "wind_speed_kt") private Integer wind_speed_kt;
    @XmlElement(name = "visibility_statute_mi") private Double visibility_statute_mi;
    @XmlElement(name = "ex_string") private String wx_string;
    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "sky_condition") private List<SkyCondition> sky_condition;
    // getters and setters
}