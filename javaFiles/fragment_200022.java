String jsonString = "{\"results\":[{\"testing\":{\"name\":\"soham\"}},{\"testing\":{\"firstname\":\"john\",\"lastname\":\"don\"}}]}";

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(jsonString);

        JsonNode resultNode = jsonNode.get("results");

        List<Activity> activityList1 = new ArrayList<Activity>();

        List<Activity2> activityList2 = new ArrayList<Activity2>();

        for (int i = 0; i < resultNode.size(); i++) {

            JsonNode testingNode = resultNode.get(i).get("testing");

            if (testingNode.has("name")) {
                String name = testingNode.get("name").asText();

                Activity activity = new Activity(name);
                activityList1.add(activity);

            }

            if (testingNode.has("firstname")) {
                String firstName = testingNode.get("firstname").asText();
                String lastName = testingNode.get("lastname").asText();

                Activity2 activity2 = new Activity2(firstName, lastName);
                activityList2.add(activity2);

            }

        }