try{
   PrintWriter outputfile = new PrintWriter(new BufferedWriter(new FileWriter (filename, true)));
   outputfile.println(totalDeposit);
   outputfile.close();
   }catch(IOException ex){
// Handle your exception
   }