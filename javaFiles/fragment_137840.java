@Test
public void start() throws Exception {



    HazelcastInstance client = produceHazelcastClient();

    Data data = new Data();

    ArrayList<Data> datas = new ArrayList<>();

    IntStream.range(0, 1000).forEach(i -> {
        datas.add(data);
    });

    wirteFile(datas,"DataLeoBefore","1");


    client.getMap("data").put("LEO", datas);

    Object redeserialized = client.getMap("data").get("LEO");

    wirteFile(redeserialized,"DataLeoAfter","1");

}

public void wirteFile(Object value, String key, String fileName) {
    try {
        Files.write(Paths.get("./" + fileName + "_" + key), SerializationUtils.serialize(((ArrayList) value)));
    } catch (IOException e) {
        e.printStackTrace();
    }
}