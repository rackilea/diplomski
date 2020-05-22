public static void main(String[] args) {
    try (FileOutputStream fos = new FileOutputStream("objects.file");
            ObjectOutputStream os = new ObjectOutputStream(fos)) {
        long position = fos.getChannel().position();
        os.writeObject(new Integer(2));
        os.flush();
        os.reset(); // added line
        fos.getChannel().position(position);
        os.writeObject(new Integer(9));
        os.flush();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}