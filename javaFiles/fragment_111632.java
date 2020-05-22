public static void LoadEtlData(String[] args) throws IOException {
    String file_name = "C:/toolbox/troux_etl.ini"; 
    ArrayList<String> records = new ArrayList<String>(); 

    try {
        BufferedReader reader = new BufferedReader(new FileReader(file_name)); 
        String line; 
        while ((line = reader.readLine()) != null){
            records.add(line); 
        }
        reader.close();
        System.out.println(records);


    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 

}