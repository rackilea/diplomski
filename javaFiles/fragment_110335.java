HandlingXmlStuff handlingXmlStuf = new HandlingXmlStuff();
handlingXmlStuf.parseDocument();
System.out.println("----values inside request tag-----");
Map<String, String> request = handlingXmlStuf.getRequest();
for (String key : request.keySet()) {
    System.out.println(key + ":" + request.get(key) + ":" + key);
}
System.out.println("----values inside current_condition tag-----");
Map<String, String> current_condition = handlingXmlStuf.getCurrent_condition();
for (String key : current_condition.keySet()) {
    System.out.println(key + ":" + current_condition.get(key) + ":" + key);
}

List<Map<String, String>> weather = handlingXmlStuf.getWeather();
for (Map<String, String> map : weather) {
    System.out.println("\n----each set of weather-----start");
    for (String key : map.keySet()) {
        System.out.println(key + ":" + map.get(key) + ":" + key);
    }
    System.out.println("----each set of weather-----end");
}