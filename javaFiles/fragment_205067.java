public void read_file(){
    try{

    // Open the file that is the first 
    // command line parameter
    FileInputStream fstream = new FileInputStream("C:\\Users\\Alos\\Desktop\\test.txt");
    // Use DataInputStream to read binary NOT text.
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    String strLine;
    int record = 0;
    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {

        String[] splits = strLine.split("\t");
        String LastName = splits[0];
        String Amount = splits[1]; 
        System.out.println("Account Number: " + record + " Name: " + LastName + ", amount: " + Amount);
        record++;
    }
    //Close the input stream
    in.close();

      }catch (Exception e){//Catch exception if any
    System.err.println("Error: " + e.getMessage());
    }