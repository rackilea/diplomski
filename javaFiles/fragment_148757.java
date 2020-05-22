import com.lowagie.tools.Executable;

try{
 Executable ex = new Executable();
 ex.openDocument(fileName);
 ex.printDocument(fileName);
 }catch(IOException e){
  e.printStackTrace();
 }