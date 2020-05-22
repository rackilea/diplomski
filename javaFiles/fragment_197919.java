JsonObject object = (JsonObject) new JsonParser().parse(new FileReader("C:\\MyData\\response.json"));
                JsonArray issues = (JsonArray) object.get("issues");
                for(int i=0; i<issues.size(); i++){
                    JsonObject issue = (JsonObject) issues.get(i);
                    String issue_key = (String) issue.get("key");
                    JsonObject fields = (JsonObject) issues.get("fields");
                    JsonObject project = (JsonObject) issues.get("project");
                    String project_name = (String) project.get("key");
                    String fields_updated = (String) fields.get("updated");
                    String fields_created = (String) fields.get("created");
                    System.out.println("Value of key" + Integer.toString(i + 1) + " is -> " + issue_key);
                }