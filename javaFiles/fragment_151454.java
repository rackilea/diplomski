try {
    FileInputStream fstream = new FileInputStream("input.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    String strLine;         
    int lineNumber = 0;
    double [] a = null;
    double [] b = null;
    // Read File Line By Line
    while ((strLine = br.readLine()) != null) {
        lineNumber++;
        if( lineNumber == 4 ){
            a = getDoubleArray(strLine);
        }else if( lineNumber == 5 ){
            b = getDoubleArray(strLine);
        }               
    }
    // Close the input stream
    in.close();
    //print the contents of a
    for(int i = 0; i < a.length; i++){
        System.out.println("a["+i+"] = "+a[i]);
    }           
} catch (Exception e) {// Catch exception if any
    System.err.println("Error: " + e.getMessage());
}