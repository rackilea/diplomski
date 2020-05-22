JSONArray petsArray = new JSONArray();
 JSONObject petO;
    //boolean spawned = false; // no need of it
    for (int i = 0; i <= 3; i++) {
        //spawned = true;
        //if (spawned) { // no need of it , has no effect, always true
            petO = new JSONObject();
            // ^^^^^^^^^^^^^^^^^
            petO.put("petID", i);
            petO.put("petOwner", "owner"+i);
            petO.put("petName", "name");
            petO.put("color", "s");
            petO.put("particle", "s");
            petsArray.add(petO);
        //}
    }