package com.example;

import java.util.HashMap;
import java.util.Map;

public class Time_Series__Daily_ {

private String _1__open;
private String _2__high;
private String _3__low;
private String _4__close;
private String _5__adjusted_close;
private String _6__volume;
private String _7__dividend_amount;
private String _8__split_coefficient;
private String time_stamp;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String get1__open() {
return _1__open;
}

public void set1__open(String _1__open) {
this._1__open = _1__open;
}

public String get2__high() {
return _2__high;
}

public void set2__high(String _2__high) {
this._2__high = _2__high;
}

public String get3__low() {
return _3__low;
}

public void set3__low(String _3__low) {
this._3__low = _3__low;
}

public String get4__close() {
return _4__close;
}

public void set4__close(String _4__close) {
this._4__close = _4__close;
}

public String get5__adjusted_close() {
return _5__adjusted_close;
}

public void set5__adjusted_close(String _5__adjusted_close) {
this._5__adjusted_close = _5__adjusted_close;
}

public String get6__volume() {
return _6__volume;
}

public void set6__volume(String _6__volume) {
this._6__volume = _6__volume;
}

public String get7__dividend_amount() {
return _7__dividend_amount;
}

public void set7__dividend_amount(String _7__dividend_amount) {
this._7__dividend_amount = _7__dividend_amount;
}

public String get8__split_coefficient() {
return _8__split_coefficient;
}

public void set8__split_coefficient(String _8__split_coefficient) {
this._8__split_coefficient = _8__split_coefficient;
}

public String getTime_stamp() {
return time_stamp;
}

public void setTime_stamp(String time_stamp) {
this.time_stamp = time_stamp;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}