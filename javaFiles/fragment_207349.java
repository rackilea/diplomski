import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
SparkConf conf = new SparkConf().setAppName("UserEventLogger").setMaster("local[2]");
JavaSparkContext sc = new JavaSparkContext(conf);

String fileData = FileUtils.readFileToString(new File("/data/pocs/text-file.json"));
List<JSONObject> jsonObject = (List<JSONObject>) JSONValue.parse("[" + fileData + "]");

JavaRDD<JSONObject> jsonRdd = sc.parallelize(jsonObject);

jsonRdd.mapToPair(new PairFunction<JSONObject, String, Integer>() {

    @Override
    public Tuple2<String, Integer> call(JSONObject appObj) throws Exception {
        JSONObject app = (JSONObject) appObj.get("app");
        JSONObject event = ((JSONObject) app.get("event"));
        String username = event.getAsString("userName");
        String eventName = event.getAsString("event_name");

        return new Tuple2<String, Integer>(username + " " + eventName, 1);
    }
}).reduceByKey(new Function2<Integer, Integer, Integer>() {

    @Override
    public Integer call(Integer v1, Integer v2) throws Exception {
        return v1 + v2;
    }
}).foreach(new VoidFunction<Tuple2<String, Integer>>() {

    @Override
    public void call(Tuple2<String, Integer> t) throws Exception {
        System.out.println(t._1 + " " + t._2);

    }
});

sc.stop();