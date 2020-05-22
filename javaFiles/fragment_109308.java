String itemNumber = //Comes from user;
String fromFile;
String[] tokens;

while((fromFile = file.br.readLine()) != null) {

   tokens = fromFile.split(", ");

   if(tokens[0].equalsIgnoreCase(itemNumber)) {

      System.out.println(tokens[1]);
      break;
   }

}