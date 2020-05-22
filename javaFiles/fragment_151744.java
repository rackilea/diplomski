hadoop jar myJar.jar com.Main -Dprop1=prop1value -Dprop2=prop2value

public int run(String args[]) {
    Configuration conf = getConf();

    conf.get("prop1"); // will resolve to "prop1Value"
    conf.get("prop2"); // will resolve to "prop2Value"
}