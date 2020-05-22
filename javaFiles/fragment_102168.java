public static JsArrayString toJsArray(String[] input) {
JsArrayString jsArrayString = JsArrayString.createArray().cast();
    for (String s : input) {
        jsArrayString.push(s);
    }
    return jsArrayString; 
}