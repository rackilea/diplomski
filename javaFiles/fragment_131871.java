@Override
public void getUsersDashboard(String token, String userId, @Suspended final AsyncResponse async) {
    List<JSONObject> list = //query persistence layer

    final Queue<String> errors = new ConcurrentLinkedQueue<>();

    Observable
    .fromIterable(list)
    .map(jsonObject -> (String) jsonObject.get("href"))
    .flatMap(link -> dashboard(token, link, errors))
    .collect(JSONArray::new, JSONArray::add)
    .subscribe(async::resume, async::resume);
}