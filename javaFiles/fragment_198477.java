/**
 * @throws IOException Input Output Exception
 * @throws ClassNotFoundException The class "file.ser" has not
 * been found in the project directory
 */
public void openCollection() throws IOException, ClassNotFoundException{
        FileInputStream e = new FileInputStream("file.ser");
        ObjectInputStream inputStream = new ObjectInputStream(e);
        inputStream.readObject();
}