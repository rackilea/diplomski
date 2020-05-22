File file = new File("Filename.csv"); 
List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8); 
for (String line : lines) { 
   String[] array = line.split(";"); 
   System.out.println(array[0]+" "+array[array.length-1]); 
}