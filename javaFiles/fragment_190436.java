String jsonread = approveCampaign.prettyPrint();
    org.json.JSONArray arrayobj = new org.json.JSONArray(jsonread);

    String[] myStringArray;
    myStringArray = new String[]{"IND", "PRI", "PUB", "NON"};


     EnTypes= new String[arrayobj.length()];

        for (int i = 0; i < arrayobj.length(); i++) {
            log.info("Response ENUMS are following\n" + arrayobj.getString(i));
            EnTypes[i] = arrayobj.getString(i);            // assigning values of response array to EnTypes
        }
        Arrays.sort(myStringArray);
        Arrays.sort(EnTypes);
        if (Arrays.equals(myStringArray, EnTypes)) {
            log.log(Status.PASS, "Values in array matched!");
        } else {
            log.log(Status.FAIL, "Values in array doesnot match");
        }
 }