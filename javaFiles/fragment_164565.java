JSONParser parser = new JSONParser();
    try {
        JSONObject JSONObj = (JSONObject) parser.parse(new FileReader("src\\main\\resources\\input.json"));

        JSONObject employeeDataJSON = (JSONObject) JSONObj.get("employeeData");

        System.out.println("employmentStartDate :" + (String) employeeDataJSON.get("employmentStartDate"));
        System.out.println("employmentEndDate :" + (String) employeeDataJSON.get("employmentEndDate"));

        JSONArray suspensionPeriodList=(JSONArray) employeeDataJSON.get("suspensionPeriodList");
        suspensionPeriodList.forEach(e->{
            System.out.println(e);
        });


    } catch (Exception e) {
        e.printStackTrace();
    }