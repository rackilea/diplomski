public static ObservableList<EmailData> readDataFromStream(byte[] bytes) {
    ObservableList<EmailData> emailData = FXCollections.observableArrayList();
    try {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        List<EmailData> list = (List<EmailData>) ois.readObject();
        emailData = FXCollections.observableList(list);
        bis.close();
        ois.close();
    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }
    return emailData;
}