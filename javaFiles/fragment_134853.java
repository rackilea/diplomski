InputStream is=...;
byte[] bytes=new byte[1028];
while(is.read(bytes)!=-1) {
log(bytes); //call function to log
parse(bytes);//call function to parse
}