public class Test {

    public static String getJsonString(Object o){
        ObjectMapper mapper = new ObjectMapper();

        //For testing
        try {
            //Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(o);
            //System.out.println(jsonInString);
            return jsonInString;


        } catch (JsonProcessingException e){
            e.printStackTrace();
        } 
        return null;
    }

    public static void main(String args[]){
        MyResponse myResponse = new MyResponse();
        myResponse.setInfo("info");
        myResponse.setMeta("meta");
        myResponse.setRespOne("respOne");
        System.out.println(myResponse.getClass().getSimpleName() + " = " + Test.getJsonString(myResponse ));
        System.out.println("------------------------------");
        MyResponseNew myResponseNew = new MyResponseNew();
        myResponseNew.setInfo("infoNew");
        myResponseNew.setMeta("metaNew");
        myResponseNew.setRespbBest("respBest");
        myResponseNew.setRespNew("respNew");
        System.out.println(myResponseNew.getClass().getSimpleName() + " = " + Test.getJsonString(myResponseNew));
        System.out.println("------------------------------");
        MyResponseUnwrapped myResponseUnwrapped = new MyResponseUnwrapped();
        GeneralSubResponse subResponse = new GeneralSubResponse();
        subResponse.setInfo("infoUnwrapped");
        subResponse.setMeta("metaUnwrapped");
        myResponseUnwrapped.setSubResponse(subResponse );
        myResponseUnwrapped.setRespOne("respTwo");
        System.out.println(myResponseUnwrapped.getClass().getSimpleName() + " = " + Test.getJsonString(myResponseUnwrapped));
        System.out.println("------------------------------");
        MyResponseNewUnwrapped myResponseNewUnwrapped = new MyResponseNewUnwrapped();
        GeneralSubResponse subResponse2 = new GeneralSubResponse();
        subResponse2.setInfo("infoNewUnwrapped");
        subResponse2.setMeta("metaNewUnwrapped");
        myResponseNewUnwrapped.setSubResponse(subResponse2 );
        myResponseNewUnwrapped.setRespbBest("respBestUnwrapped");
        myResponseNewUnwrapped.setRespNew("respNewUnwrapped");
        System.out.println(myResponseNewUnwrapped.getClass().getSimpleName() + " = " + Test.getJsonString(myResponseNewUnwrapped));
    }

}