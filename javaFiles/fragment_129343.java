Map<String, Map<String, Double>> outerMap = new HashMap<>();

Map<String, Double> innerMap = new HashMap<>();
innerMap.put("1", 1.0);
innerMap.put("2", 2.0);

outerMap.put("key1", innerMap);

// write to file

try (ObjectOutput objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("myfile2.txt", false)))) {
    objectOutputStream.writeObject(outerMap);
} catch (Throwable cause) {
    cause.printStackTrace();
}

// read from file

try (ObjectInput objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("myfile2.txt")))) {
    outerMap = (Map<String, Map<String, Double>>) objectInputStream.readObject();
} catch (Throwable cause) {
    cause.printStackTrace();
}