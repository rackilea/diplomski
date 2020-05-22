public static ObservableList<EmailData> readDataFromStream(byte[] bytes) {
ObservableList<EmailData> emailData = FXCollections.observableArrayList(ed ->
        new Observable[]{
                ed.nameProperty(),
                ed.loginProperty(),
                ed.passwordProperty(),
                ed.commentsProperty()
        });
    try {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        List<EmailData> list = (List<EmailData>) ois.readObject();
            emailData = FXCollections.observableList(
        list,
        (EmailData tp) -> new Observable[]{tp.nameProperty(), tp.passwordProperty(),
                tp.loginProperty(), tp.commentsProperty()});
        bis.close();
        ois.close();
    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }
    return emailData;
}