try {
    outFile = new DataOutputStream(new FileOutputStream(dataFile));

    outFile.writeUTF(titleField.getText());

    // convert string to int
    int itemN = Integer.parseInt(itemNField.getText());
    outFile.writeInt(itemN);

    outFile.flush();
    outFile.close();
}
catch(IOException error) {
    error.printStackTrace();
}