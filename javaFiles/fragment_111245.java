package com.google.twentyNumbers.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class TwitterResults extends JavaScriptObject {

protected TwitterResults() { 

}
//public final String getMaxId() { return "500"; }
public final native JsArray<Tweet> getResults() /*-{ return this.results; }-*/;

public final native String getMaxId() /*-{ return ''+this.max_id; }-*/;
public final native String getRefreshUrl() /*-{ return this.refresh_url; }-*/;
public final native String getNextPage() /*-{ return this.next_page; }-*/;