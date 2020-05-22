ProcessBuilder pb = new ProcessBuilder("ssh", 
                                       "user@127.0.0.1", 
                                       "export MYVAR=this/dir/is/cool; /run/my/script/myScript; echo $MYVAR");
pb.redirectErrorStream(); //redirect stderr to stdout
Process process = pb.start();
InputStream inputStream = process.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
String line = null;
while((line = reader.readLine())!= null) {
    System.out.println(line);
}
process.waitFor();