try{
   FileInputStream fstream = new FileInputStream("abc.log");
   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
   String strLine;
   /* read log line by line */
   while ((strLine = br.readLine()) != null)   {
     /* parse strLine to obtain what you want */
     System.out.println (strLine);
   }
   fstream.close();
} catch (Exception e) {
     System.err.println("Error: " + e.getMessage());
}