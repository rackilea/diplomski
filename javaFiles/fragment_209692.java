public static void main(String[] args) {
    JSONObject jsonObject = new JSONObject("{\"Staff\": {\"Managers\": [{\"name\": \"Chris\",\"age\": 43,\"position\": \"Retail\"},{\"name\": \"John\",\"age\": 36,\"position\": \"Sales\"}]}}");

    List<Manager> managersList = new ArrayList<Manager>();

    JSONObject staff = jsonObject.getJSONObject("Staff");
    JSONArray managers = staff.getJSONArray("Managers");

    for (int index = 0; index < managers.length(); index++) {
        JSONObject resultObject = managers.getJSONObject(index);

        Manager manager = new Manager();
        manager.setName(resultObject.getString("name"));
        manager.setAge(resultObject.getInt("age"));
        manager.setPosition(resultObject.getString("position"));

        managersList.add(manager);
    }

    Collections.sort(managersList, new Comparator<Manager>() {
        @Override
        public int compare(Manager object1, Manager object2) {
            return Integer.compare(object1.getAge(), object2.getAge());
        }
    });

    for (Manager iterator : managersList) {
        System.out.println(iterator.getName() + " --- " + iterator.getAge() + " --- " + iterator.getPosition());
    }
}