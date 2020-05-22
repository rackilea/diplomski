/* writing */
public void writeSelling(List<String> wordLists) throws IOException {
    fileOutPutStream = new FileOutputStream (file);
    write= new ObjectOutputStream (fileOutPutStream);
    for (String s : wordLists) {
        write.writeObject(s);
    }
    write.close();
    contador++;
}