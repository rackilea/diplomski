public int run(String args[]) {
    Configuration conf = getConf();

    conf.set("prop3", "blah");

    Job job = new Job(conf); // job will have a deep copy of conf

    conf.set("prop4", "dummy"); // here we're amending the original conf

    job.getConfiguration().get("prop4"); // will resolve to null
}