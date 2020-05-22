public static String getAllHashtags() {

    String body = "Hello #world How are #you";
    String allHashtags = "";

    int index = -1;
    while ((index = body.indexOf('#')) != -1) {
        // cut the string up to the first hashtag
        body = body.substring(index+1);
        // we need to check if there is a empty space at the end or not
        if(body.indexOf(' ') != -1) {
            allHashtags += "#" + body.substring(0,body.indexOf(' '));
        }else {
            allHashtags += "#" + body;
        }

    }
    return allHashtags;
}