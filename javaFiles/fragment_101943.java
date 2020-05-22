private SocialBean bean = new SocialBean();
public JsonRestApi() {

try {

    String Response = "{\"Youtube Data\":\"Views\":\"1047\"}";

    JSONParser parser = new JSONParser();

    try {

        Object obj = parser.parse(Response);

        JSONObject jsonObject = (JSONObject) obj;
        JSONObject jsonObject3  = (JSONObject)jsonObject.get("Youtube Data");

        Long yviews = new Long((String)jsonObject3.get("Views"));

        bean.setViews(yviews);

 }
}

public SocialBean getSocialBean(){
   return bean;
}