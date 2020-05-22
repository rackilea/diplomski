Object content = jsonObjectMessage_Content.get("a");
if (content == null) {
    // No content
} else {
    String string = object.toString();
    // Do something with the String. It's a String now, regardless
    // of whether it was a String, Integer, Long, etc. before
}