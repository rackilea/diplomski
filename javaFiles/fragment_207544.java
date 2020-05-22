File dest = getDestinationFile(source, destination);
if(dest == null) return false;

in = new BufferedInputStream(new  FileInputStream(source));
out = new BufferedOutputStream(new  FileOutputStream(dest));

int i;
while((i = in.read()) != -1){
   out.write(i);
}
out.flush();