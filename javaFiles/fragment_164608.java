try {   ...
        JSONObject rootJSON = (JSONObject) new JSONParser().parse(jsonString);
        JSONArray dataList = (JSONArray) rootJSON.get("data");
        for(Object projectObj: dataList.toArray()){
            JSONObject project = (JSONObject)projectObj;
            JSONArray issueList = (JSONArray) project.get("issue");
            for(Object issueObj: issueList.toArray()){
                JSONObject issue = (JSONObject) issueObj;
                //do something with the issue
            }
        }
    } catch (ParseException e) {
        //do smth
        e.printStackTrace();
    }