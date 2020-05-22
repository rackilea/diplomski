public static String getAllHashtags() {

    String body = "Hello #world How are #you";
    String tokens[] = body.split("\\s+");
    String allHashtags = "";

    for (String token : tokens) {
        if (token.startsWith("#")) {
            allHashtags += token; 
        }
    }
    return allHashtags;
}