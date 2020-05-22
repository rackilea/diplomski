File file = new File("E:\\" + "Person1" + ".txt");
int increase=1;
while(file.exists()){
     increase++;
     file = new File("E:\\" + "Person" + increase+ ".txt");
} 
if(!file.exists()) {
   try {

    String content = textfile.toString();
    file.createNewFile();

    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(content);
    bw.close();

    System.out.println("Done");

}catch (IOException e){
   }