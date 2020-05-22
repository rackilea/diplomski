PrintWriter writer = null;
try {
    writer = new PrintWriter(new FileWriter(new File("pathToNewFile")));

    //do reading etc
    writer.println(stringVariableToWrite);

} catch (IOException e) {
    System.err.println(e);
} finally {
    if (writer != null){
        writer.close();
        if (writer.checkError()) {
             System.err.println(e);
        }
    }
}