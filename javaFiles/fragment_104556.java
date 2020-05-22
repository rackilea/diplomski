public static void removeLine(BufferedReader br , File f,  String Line) throws IOException{
    File temp = new File("temp.txt");
    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
    String removeID = Line;
    String currentLine;
    while((currentLine = br.readLine()) != null){
        String trimmedLine = currentLine.trim();
        if(trimmedLine.equals(removeID)){
            currentLine = "";
        }
        bw.write(currentLine + System.getProperty("line.separator"));

    }
    bw.close();
    br.close();
    boolean delete = f.delete();
    boolean b = temp.renameTo(f);
}