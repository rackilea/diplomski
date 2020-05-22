JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader(
                "sample.json"));

        JSONObject jsonObject = (JSONObject) obj;

        Set<String> keySet = jsonObject.keySet();
        List<String> doctors = new ArrayList<>();

        for (String keys : keySet) {
            JSONObject singleUser = (JSONObject) jsonObject.get(keys);
            String role = singleUser.get("role").toString();
            if (role.equals("Doctor")) {
                doctors.add(keys);
            }
        }
        System.out.println("Doctor users are --" + doctors);