public static String ReadFile(String filePath) throws FileNotFoundException 
{

   File inputFile = new File (filePath);
   Scanner in = new Scanner (inputFile);
   String str = new String ("");
   while (in.hasNextLine())
   {
//       str += in.nextLine(); //this is wrong
       str = in.nextLine() + "\n" + str;
   }

   in.close();
   return str; // this is all the text in the file. thats the purpose of this methods 

}