public class addQuotes{
    String dir = "enter file location here";
    File quotes = new File(dir);

private String readFile(){
    String q = "";

    try(FileInputStream fin = new FileInputStream(dir)){
        int s = (int) quotes.length();
        byte[] r = new byte[s];
        fin.read(r);
        q = new String(r);

    }catch(Exception e){
        e.printStackTrace();
    }
    return q;
}

private void writeFile(FileOutputStream fos, String output) throws IOException{
    byte[] data = output.getBytes();
    fos.write(data);
}

public addQuotes() {
    String add = readFile().replaceAll("(\\w+)", "\"$1\"");
    try{
        FileOutputStream fos =  new FileOutputStream(dir);
        writeFile(fos, add);
    }catch(Exception e){
        e.printStackTrace();
    }
  }
}