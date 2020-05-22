JSONArray hitsArray;
             JSONArray responseArray = new JSONArray();
             JSONObject responseObj;
             String fileRelativePath=null;

             JSONObject json = new JSONObject(responseBody);
             JSONObject hits = json.getJSONObject("hits");
             hitsArray = hits.getJSONArray("hits");
                for (int i=0; i<hitsArray.length(); i++) {
                JSONObject h = hitsArray.getJSONObject(i);
                JSONObject sourceJObj = h.getJSONObject("_source");
                        responseObj = new JSONObject();
                        fileRelativePath = sourceJObj.optString("path").toString().concat(sourceJObj.optString("filename").toString());
                        responseObj.put("id", Integer.parseInt(sourceJObj.opt("id").toString()));
                        responseObj.put("fileRelativePath", fileRelativePath);
                        responseArray.put(responseObj);

                }
                System.out.println("Response Length -->"+responseArray.length()+"Response --->"+responseArray.toString());