List<Data> datas = new ArrayList<Data>();
try {
    stream = new BufferedReader(new FileReader(csvFileName));
    while ((line = stream.readLine()) != null) {
        String[] splitted = line.split(",");
        Data data = new Data();
        data.setEmail(splitted[0]);
        data.setFname(splitted[1]);
        data.setLname(splitted[2]);

        datas.add(data);
    }
}