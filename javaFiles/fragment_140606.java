public boolean checkStatus(){
   boolean result = true;  // default value.
   try{

        InputStream fstream = MyRegDb.class.getClassLoader().getResourceAsStream("textfile.txt");
        // Use DataInputStream to read binary NOT text.
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        //Read File Line By Line
        strLine = br.readLine();
        // Print the content on the console
        System.out.println (strLine);

        ind.close();
        if(strLine.equals("1")){

            result = false;   
        }else{
            result = true;    
        }

    }catch(Exception e){}
    return result;
}