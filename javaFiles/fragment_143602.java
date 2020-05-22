QueryResponse projectDefects = restApi.query(defectRequest);
        if (projectDefects.wasSuccessful()) {
            for (JsonElement result : projectDefects.getResults()) {
                JsonObject defect = result.getAsJsonObject();
                try {
                    JsonObject ownerJsonObject = defect.get("Owner").getAsJsonObject();
                    String ownerRef = ownerJsonObject.get("_ref").getAsString();
                    GetRequest ownerRequest = new GetRequest(ownerRef);
                    GetResponse ownerResponse = restApi.get(ownerRequest);
                    JsonObject ownerObj = ownerResponse.getObject();
                    System.out.println(String.format("Read owner. EmailAddress = %s",
                            ownerObj.get("EmailAddress").getAsString()));
                } catch (java.lang.IllegalStateException ise) {
                    // System.out.println("IllegalStateException caught: ");
                    // ise.printStackTrace();
                }
            }
        }