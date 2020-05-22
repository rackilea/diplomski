try (FileOutputStream fos = new FileOutputStream("file");
     ObjectOutputStream outputStream = new ObjectOutputStream()) {

    outputStream.writeObject(obj1);
    outputStream.writeObject(obj2);
    outputStream.writeObject(obj3);
} catch(IOException e) {
    System.out.println("IOException");
    System.exit(0);
}