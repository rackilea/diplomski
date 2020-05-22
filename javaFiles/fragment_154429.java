import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class XmlApp {

    public static void main(String[] args) throws Exception {
        System.out.println(new File(".").getAbsolutePath());
        File xml = new File("./src/main/resources/test.xml");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setDefaultUseWrapper(false);
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        TypeReference<List<NowPlayingInfo>> type = new TypeReference<List<NowPlayingInfo>>() {
        };
        List<NowPlayingInfo> infos = xmlMapper.readValue(xml, type);
        List<ScheduleItem> items = infos.stream()
            .map(NowPlayingInfo::getPropertiesAsMap)
            .map(m -> {
                ScheduleItem item = new ScheduleItem();
                item.setSong(m.get("cue_title"));
                item.setDatetime(Long.parseLong(m.get("cue_time_start")));
                return item;
            }).collect(Collectors.toList());
        items.forEach(System.out::println);
    }
}

class ScheduleItem {

    private String song;
    private String artist;
    private String cover;
    private Long datetime;

    //getters, setters, toString
}

class NowPlayingInfo {

    private String mountName;
    private long timestamp;
    private String type;

    @JsonProperty("property")
    private List<Property> properties;

    public Map<String, String> getPropertiesAsMap() {
        Map<String, String> map = new LinkedHashMap<>();
        properties.forEach(p -> map.put(p.getName(), StringUtils.strip(p.getValue())));
        return map;
    }

    //getters, setters, toString
}

class Property {

    @JacksonXmlText
    private String value;

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    //getters, setters, toString
}