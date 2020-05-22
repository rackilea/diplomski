public static void main(String[] args) {
    String desc = "\"description\": \"";
    String fields = "\",\"fields\"";
    int indexStart = njson.indexOf(desc) + desc.length() ;
    int indexEnd = njson.indexOf(fields);

    String ex = njson.substring(indexStart, indexEnd);

    String str = JSONObject.quote(ex);

    String begin = njson.substring(0, indexStart - 1);
    String end = njson.substring(indexEnd + 1);

    String validJSon = begin + str + end;

    JSONObject obj = new JSONObject(validJSon);
}