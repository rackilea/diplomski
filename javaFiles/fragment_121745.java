public static class OuterObject {
    String name;
    String url;

    BuildProperties properties;

}

public static class BuildProperties {
    String full_url;
    int number;
    Map<String, String> scm = new HashMap<String, String>() {{
        put("url":"institutional/fcm-dummy-web");
        //etc
    }};

}