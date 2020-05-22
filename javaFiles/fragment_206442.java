package com.example;

import java.util.HashMap;
import java.util.Map;

public class Meta_Data {

private String _1__Information;
private String _2__Symbol;
private String _3__Last_Refreshed;
private String _4__Output_Size;
private String _5__Time_Zone;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String get1__Information() {
return _1__Information;
}

public void set1__Information(String _1__Information) {
this._1__Information = _1__Information;
}

public String get2__Symbol() {
return _2__Symbol;
}

public void set2__Symbol(String _2__Symbol) {
this._2__Symbol = _2__Symbol;
}

public String get3__Last_Refreshed() {
return _3__Last_Refreshed;
}

public void set3__Last_Refreshed(String _3__Last_Refreshed) {
this._3__Last_Refreshed = _3__Last_Refreshed;
}

public String get4__Output_Size() {
return _4__Output_Size;
}

public void set4__Output_Size(String _4__Output_Size) {
this._4__Output_Size = _4__Output_Size;
}

public String get5__Time_Zone() {
return _5__Time_Zone;
}

public void set5__Time_Zone(String _5__Time_Zone) {
this._5__Time_Zone = _5__Time_Zone;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}