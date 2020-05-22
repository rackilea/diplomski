public static List<String> readFile() throws IOException {      
    try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
        List<String> listOfData = new ArrayList<>();            
        String d;
        while ((d = br.readLine()) != null) {
            String[] split = d.split(";");  // <-- change made here
            listOfData.add(split[1]);           
        }           
        return listOfData;      
     }  
}