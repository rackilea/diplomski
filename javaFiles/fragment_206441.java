package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {

private Meta_Data meta_Data;
private List<Time_Series__Daily_> time_Series__Daily_ = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Meta_Data getMeta_Data() {
return meta_Data;
}

public void setMeta_Data(Meta_Data meta_Data) {
this.meta_Data = meta_Data;
}

public List<Time_Series__Daily_> getTime_Series__Daily_() {
return time_Series__Daily_;
}

public void setTime_Series__Daily_(List<Time_Series__Daily_> time_Series__Daily_) {
this.time_Series__Daily_ = time_Series__Daily_;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}