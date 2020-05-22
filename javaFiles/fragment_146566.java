package pojos;

import com.google.auto.value.AutoValue;

import java.util.List;
import java.util.Map;

@AutoValue
public abstract class KeyValuesMapHolder {

    public abstract List<KeyValue<String,String>> keyValues();
    public abstract Map<Integer,String> mapping();

    public static KeyValuesMapHolder create(List<KeyValue<String, String>> keyValues, Map<Integer, String> mapping) {
        return new AutoValue_KeyValuesMapHolder(keyValues, mapping);
    }

}