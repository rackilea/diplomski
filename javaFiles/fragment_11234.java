@Override
public void configure(JobConf conf) {
    this.conf = conf;
}

@Override.
public void map(................) throws IOException {

        String filename = conf.get("map.input.file");
        output.collect(new Text(filename), value);
}