int line = 1;
String read = null;
while((read = in.readLine()) != null){
   if(line!=2)
   {
     dostemp.writeBytes(read);     
   } 
   line++;
}