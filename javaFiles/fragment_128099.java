returnString = 
    "{\"success\": true,   \"payload\": \"success!\", \"foo\": " // <-- missing property name
        + "{\"userIdA\":\"" + user1.getUserId()
        + "\", \"userIdB\":\"" + user2.getUserId()
        + "\", \"tagName\":\"" + tagName + "\" }"
    + "}";