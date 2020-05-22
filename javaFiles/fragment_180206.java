List<Map<String, Object>> featureServices = getUnsubscribedSevice();

for (Map<String, Object> featureService : featureServices) {
    for (Map.Entry<String, Object> entry : featureService.entrySet()) {
       System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}