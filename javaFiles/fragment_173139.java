try(
    FileOutputStream fos = new FileOutputStream("bytes.info");
    ObjectOutputStream oos = new ObjectOutputStream(fos)
) {
    oos.writeObject(data);
}