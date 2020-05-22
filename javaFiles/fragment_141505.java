public class ScheduledUpdater implements Runnable {

    private final MockDB database;
    private final String field;

    public ScheduledUpdater(MockDB database, String field) {
        this.database = database;
        this.field = field;
    }

    @Override
    public void run() {
        // here we should synchronize on a whole DB access object 
        // as we need get & set to be atomic together
        JSONObject json;
        synchronized (database) {
            json = database.getJSON();

            JSONObject xData;
            xData = (JSONObject) json.get(field);
            Object obj = xData.get("data");
            List<Integer> array = new ArrayList<>((List<Integer>) obj);
            array.add(Collections.max(array) + 1); // add new item to json array
            xData.put("data", array);

            database.setJSON(json);
        }
        printValues(json);
    }

    private void printValues(JSONObject json) {
        JSONObject    ao = (JSONObject) json.get("a");
        List<Integer> ad = (List<Integer>) ao.get("data");
        JSONObject    bo = (JSONObject) json.get("b");
        List<Integer> bd = (List<Integer>) bo.get("data");
        System.out.println(String.format("a: %02d; b: %02d", Collections.max(ad), Collections.max(bd)));
    }

}