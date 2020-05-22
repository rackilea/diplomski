for(int i=0;i<=str.length();i=i+3)
{
   try
   {
        lastIndex = i;
        String stringPiece = str.substring(i, i+3);
        pw.println(stringPiece);
   }
   catch(Exception arr){
       String stringPiece = str.substring(lastIndex, str.length());
       pw.println(stringPiece);
   }
}