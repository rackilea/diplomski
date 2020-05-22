try (BufferedReader myReader = new BufferedReader(new FileReader("file1.txt"))) {
    String text = null;
    while ((text = myReader.readLine()) != null) {
        jTextArea1.append(text + "\n");
    }
} catch (IOException exp) {
    exp.printStackTrace();
}