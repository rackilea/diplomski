public static void readIN() throws Exception{
    BufferedReader br = new BufferedReader(new FileReader("test.txt"));
    String line = null;

    while ((line = br.readLine()) != null) {
        String[] values = line.split(","); // want to be call
        for (String inputIN : values) {
            inputIN = values[2];
        }
        checkStatus(values);
    }
    br.close(); 
}


public static void checkStatus(String[] values) {
    // call variable 'values' here
    System.out.println(values);
}