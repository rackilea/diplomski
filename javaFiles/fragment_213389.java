public static String[] getParams(Scanner input){
   String[] data = new String[2];
   System.out.print("Name? ");
   data[0] = input.nextLine();
   System.out.print("Age? ");
   data[1] = input.nextLine();
   System.out.println("Search parameters > Name: " + data[0] + "\tAge: " + data[1]);
   return data;
}

public static String searchFile(String filePath, String[] param) throws IOException, FileNotFoundException{
   BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
   List<String> fileData = new ArrayList<String>();
   List<String> NamesAndAge = new ArrayList<String>();
   String line;

   while((line = br.readLine()) != null){
      fileData.add(line);
   }
   br.close();
   for(String s : fileData){
      String[] split = s.split(" ");
      NamesAndAge.add(split[0] + " " + split[1]);
   }

   for(String n : NamesAndAge){
      if(n.equalsIgnoreCase(param[0] + " " + param[1])){
         int index = NamesAndAge.indexOf(n);
         return fileData.get(index).substring(n.length()).trim();
      }
   }
   return null;
}