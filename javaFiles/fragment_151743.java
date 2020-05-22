hadoop jar myJar.jar com.Main prop1value prop2value

public static void main(String args[]) {
    Configuration conf = new Configuration();
    conf.set("prop1", args[0]);
    conf.set("prop2", args[1]);

    conf.get("prop1"); // will resolve to "prop1Value"
    conf.get("prop2"); // will resolve to "prop2Value"
}