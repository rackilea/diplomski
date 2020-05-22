SMObject resultObj;

 if (results != null && results.size() > 0) {
        List<SMObject> myResults = feedback.get(make); 
        resultObj = myResults.get(0);
        resultObj.put("resolved", "1");
        resultObj.put("accepted", "1");
        resultObj.put("declined", "0");

        String model = (String)resultObj.get("model");
    }