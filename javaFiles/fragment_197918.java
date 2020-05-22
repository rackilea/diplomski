JsonObject object = (JsonObject) new JsonParser().parse(new FileReader("C:\\MyData\\response.json"));
                JsonArray issues = (JsonArray) object.get("issues");
                for(int i=0; i<issues.size(); i++){
                    JsonObject issue = (JsonObject) issues.get(i);
                    String issue_key = (String) issue.get("key");
                    System.out.println("Value of key" + Integer.toString(i + 1) + " is -> " + issue_key);
                }