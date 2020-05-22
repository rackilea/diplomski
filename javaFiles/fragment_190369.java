Object content = jsonObjectMessage_Content.get("a");
if (content instanceof String) {
    String string = (String) content;
    // Do something ...
} else {
    // Not a String
}