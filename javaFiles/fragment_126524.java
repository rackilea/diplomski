File f = new File(filename);
String extension = "";
int g = 0;
int i = f.lastIndexOf('.');
extension = fileName.substring(i+1);

while(f.exists()) {      
  if (i > 0) 
  {  f.renameTo(f.getPath() + "\" + (f.getName() + g) + "." + extension); }
  else
  {  f.renameTo(f.getPath() + "\" + (f.getName() + g)); }     

  g++;    
}