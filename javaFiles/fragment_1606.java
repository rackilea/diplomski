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

ObjectMapper mapper = new ObjectMapper();
byte[] writeData1Bytes = mapper.writeValueAsBytes(writeData1);
out.write(writeData1Bytes);
byte[] writeData2Bytes = mapper.writeValueAsBytes(writeData2);
out.write(writeData2Bytes);
byte[] writeData3Bytes = mapper.writeValueAsBytes(writeData3);
out.write(writeData3Bytes);
out.writeTo(fileOut);

// TODO: How to deserialize?
int pos = 0;
byte[] readData = new byte[1000];
fileIn.read(readData);
String readData1 = mapper.readValue(readData, pos, writeData1Bytes.length, String.class);
pos += writeData1Bytes.length;
Integer readData2 = mapper.readValue(readData, pos, writeData2Bytes.length, Integer.class);
pos += writeData2Bytes.length;
ArrayList readData3 = mapper.readValue(readData, pos, writeData3Bytes.length, ArrayList.class);
pos += writeData3Bytes.length;

System.out.printf("readData1 = %s%n", readData1);
System.out.printf("readData2 = %s%n", readData2);
System.out.printf("readData3 = %s%n", readData3);