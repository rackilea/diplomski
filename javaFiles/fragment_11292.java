public void writeSelling(List<String> wordList) throws IOException {
    fileOutPutStream = new FileOutputStream (file,true);
    DataOutputStream write =new DataOutputStream(fileOutPutStream);
    for (String s : wordList){
        d.writeUTF(s);
    }
    write.close();
}