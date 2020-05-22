public aspect JSONExceptionAdvice {

    declare soft: org.json.JSONException: @annotation(JSONHandler);

    after() throwing(org.json.JSONException e): @annotation(JSONHandler) {
        System.out.println(e);
    } 

}