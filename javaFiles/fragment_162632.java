public static List<String[]> read(String document) throws IOException{

        List<String[]> data = null;
        try{
            CSVReader reader = new CSVReader(new FileReader(document));
            data = reader.readAll();
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }