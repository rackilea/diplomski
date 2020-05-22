import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
class Stats
{
    private String metric;
    private long timestamp;
    private int value;
    private Map<String,String> tags=new HashMap<>();
    /**
     * @return the metric
     */
    public String getMetric() {
        return metric;
    }
    /**
     * @param metric the metric to set
     */
    public void setMetric(String metric) {
        this.metric = metric;
    }
    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * @return the tags
     */
    public Map<String, String> getTags() {
        return tags;
    }
    /**
     * @param tags the tags to set
     */
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

}
public class JSON {

    public static final void main(String args[])
    {
        List<Stats> stats=new ArrayList<Stats>();
        // Fill data, you know, whatever
        Stats stat1=new Stats();
        stat1.setMetric("metric1");
        stat1.getTags().put("tag1","value1");
        stat1.getTags().put("tag2","value2");

        Stats stat2=new Stats();
        stat2.setMetric("metric2");  
        // ... Fill data...

        // ... Add stats to array
        stats.add(stat1);
        stats.add(stat2);        

        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(stats));
    }
}