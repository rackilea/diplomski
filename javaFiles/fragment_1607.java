public class JacksonTest {
  public static class DataNode {
    @JsonProperty("data1")
    private String data1;
    @JsonProperty("data2")
    private int data2;
    @JsonProperty("data3")
    private List<String> data3;

    //needed for Jackson
    public DataNode() {
    }

    public DataNode(String data1, int data2, List<String> data3) {
      this.data1 = data1;
      this.data2 = data2;
      this.data3 = data3;
    }
  }

  public static void main(String[] args) throws Exception {
    File dataFile = new File("jackson.txt");
    if(!dataFile.exists())
      dataFile.createNewFile();
    FileOutputStream fileOut = new FileOutputStream(dataFile);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    FileInputStream fileIn = new FileInputStream(dataFile);

    String writeData1 = "test data";
    int writeData2 = 10;
    List<String> writeData3 = new ArrayList<String>();
    writeData3.add("list data1");
    writeData3.add("list data1");

    DataNode writeData = new DataNode(writeData1, writeData2, writeData3);

    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(out, writeData);
    out.writeTo(fileOut);

    // TODO: How to deserialize?
    DataNode readData = mapper.readValue(fileIn, DataNode.class);

    System.out.printf("readData1 = %s%n", readData.data1);
    System.out.printf("readData2 = %s%n", readData.data2);
    System.out.printf("readData3 = %s%n", readData.data3);
  }
}