Map<String, List<String>> data = new HashMap<>();
data.put("myKey", List.of("A", "B", "C"));

File outFile = new File("out.bin");
try (FileOutputStream fos = new FileOutputStream(outFile);
     BufferedOutputStream bos = new BufferedOutputStream(fos);
     ObjectOutputStream oos = new ObjectOutputStream(bos)) {
    oos.writeObject(data);
    oos.flush();
}