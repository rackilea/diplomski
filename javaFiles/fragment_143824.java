package tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LineItem
{

    private final Map<String, StringProperty> fields;

    public LineItem(Map<String, String> record)
    {
        this.fields = new HashMap<>();
        for (String key : record.keySet())
        {
            this.fields.put(key, new SimpleStringProperty());
        }
        for (Entry<String, String> entry : ((Set<Entry<String, String>>) record.entrySet()))
        {

            this.fields.get(entry.getKey()).set(entry.getValue());
        }
    }

    public final StringProperty fieldProperty(String key)
    {
        return this.fields.get(key);
    }

}