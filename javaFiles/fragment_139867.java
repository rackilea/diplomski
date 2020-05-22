String content = "Add this everytime";

File file =new File("example.txt");

//if file does not exists, then create it
if(!file.exists()){
   file.createNewFile();
}

//true = append file
FileWriter fileWritter = new FileWriter(file.getName(),true);
BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
bufferWritter.write(content);
bufferWritter.close();

System.out.println("Done");