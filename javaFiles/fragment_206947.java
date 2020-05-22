public String getEmailFromToken(String decodedToken) {
        // if you decoded your token it will looks like the prepareToken String
        String stubUrl = "http://localhost"+decodedToken;
        Map<String,String> map = splitQuery(new URL(stubUrl));
        return map.get("timeToken");
    }