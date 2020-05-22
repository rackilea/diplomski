String token = // init it
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileReader(thefileName)));

for (String line = reader.nextLine(); line !=null; line = reader.nextLine()) {
    String[] parts = line.split(",");
    if (token.equals(parts[0])) {
       // this is the line you are looking for...
    }
}