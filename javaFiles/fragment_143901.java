String filein = "inputfile";
String fileout = filein + ".tmp";

try(
   BufferedReader reader = new BufferedReader(new FileReader(filein));
   Writer writer = new BufferedWriter(FileWriter(fileout))
) {
      while ((String line = bufferedReader.readLine()) != null) {    
          writer.write(line.replace("þ", "t");
      }
}

Files.move(Paths.get(fileout)), 
           Paths.get(filein), 
           CopyOption.REPLACE_EXISTING);