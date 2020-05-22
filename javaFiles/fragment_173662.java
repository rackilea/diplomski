// Exception handling omitted as this is just test code
public static void main(String[] args) throws Exception {
    File file = new File("D:/serializable.txt");
    try (FileOutputStream fos = new FileOutputStream(file);
         ObjectOutputStream ous = new ObjectOutputStream(fos)) {
        SerialTest st = new SerialTest();
        ous.writeObject(st);
    }
    try (FileInputStream fis = new FileInputStream(file);
         ObjectInputStream ois = new ObjectInputStream(fis)) { 
        SerialTest st = (SerialTest) ois.readObject();
        System.out.println(st);
    }
}