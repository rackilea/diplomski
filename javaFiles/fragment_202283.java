Map<String, List<MyData>> payincash1 = new LinkedHashMap<String, List<MyData>>();

MyData data = new MyData(row[0], row[1], row[2], row[3]);

List master = payincash1.get((String)row[2]);
if (master == null) {

    master = new List<MyData>();
    payincash1.put((String)row[2], master);

}

master.add(data);