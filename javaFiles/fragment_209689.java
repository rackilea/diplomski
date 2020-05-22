List<Manager> managersList = new ArrayList<Manager>();

JSONObject staff = jsonObject.getJSONObject("Staff");
JSONArray managers = staff.getJSONArray("Managers");

for (int index = 0; index < managers.length(); index++) {
    JSONObject resultObject = managers.getJSONObject(index);
    System.out.println(resultObject);

    Manager manager = new Manager();
    manager.setName(resultObject.getString("name");
    manager.setAge(resultObject.getInt("age");
    manager.setPosition(resultObject.getString("position");

    managersList.add(manager);
}