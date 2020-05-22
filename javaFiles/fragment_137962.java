BufferedReader br = new BufferedReader(new FileReader(file));
String line;
while((line = br.readLine()) != null) {
    String [] split = line.split(",");
    String name= split[0];        
    String surname= split[1];
    Integer age= Integer.parseInt(split[2]);
    //save it to the database
}
//close the reader somewhere