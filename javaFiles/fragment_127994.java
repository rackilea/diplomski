while(cont){
 try{
   Object x = (Object) in.readObject();
 } catch (EOFException e) {
   cont = false; // or just break
 }
}