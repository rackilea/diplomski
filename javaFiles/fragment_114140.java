try {  
    // make a 'file' object   
    File file = new File("e:/mytxt.txt");  
    //  Get data from this file using a file reader.   
    FileReader fr = new FileReader(file);  
    // To store the contents read via File Reader  
    BufferedReader br = new BufferedReader(fr);
    // Read br and store a line in 'data', print data  
    String data;  

    while((data = br.readLine()) != null)   
    {  
        int posWhite = data.indexOf(' ');
        String digit = data.substring(0, posWhite);
        String url = data.substring(posWhite + 1);
        System.out.println(url + "/" + digit);  
    }                                  
} catch(IOException e) {  
    System.out.println("bad !");  
}