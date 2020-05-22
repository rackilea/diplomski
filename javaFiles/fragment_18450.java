public static class Data {
    private int numberOfDirectories;
    private int fileSystemSize;
    private byte[] bitMap;
    private File someObject;
    // getters and setters .... 
}

final String name = "tmp.data";
Data data = new Data();
data.setNumberOfDirectories(2);
data.setFileSystemSize(4);
data.setBitMap(new byte[] { 0, 1, 0 });
data.setSomeObject(new File("."));
ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(name));
outputStream.writeObject(data);
outputStream.close();
// ....
ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(name));
Data readData = (Data) inputStream.readObject();
System.out.println("numberOfDirectories:" + readData.getNumberOfDirectories());
System.out.println("fileSystemSize:" + readData.getFileSystemSize());
System.out.println("bitMap:" + readData.getBitMap());
System.out.println("someObject:" + readData.getSomeObject());
inputStream.close();