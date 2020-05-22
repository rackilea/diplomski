List<Checks> list = new ArrayList<>();
list.add(new Checks("check1", true));
list.add(new Checks("check2", false));
list.add(new Checks("check3", false));
list.add(new Checks("check4", true));
list.add(new Checks("check5", true));

JSONObject object = new JSONObject();



    JSONArray array = new JSONArray();
    try {           
        for (int i = 0; i < list.size(); i++) {
            JSONObject checkobjects = new JSONObject();
            checkobjects.put("check_id", list.get(i).getCheck());
            checkobjects.put("completed", list.get(i).getCompleted());
            array.put(checkobjects);
        }
        object.put("checks", array);
    } catch (JSONException e1) {
        e1.printStackTrace();
    }

    System.out.println(object);

}