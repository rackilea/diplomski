public static JsArrayString toJsArray(String[] input) {
    JsArrayString jsArrayString = createEmptyJsArrayString();
    for (String s : input) {
        jsArrayString.push(s);
    }
    return jsArrayString; 
}

private static native JsArrayString createEmptyJsArrayString() /*-{
    return [];
}-*/;