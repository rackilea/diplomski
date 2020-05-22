FileReader fr = new FileReader ("products.txt"); 
Bufferedreader br = new BufferedReader(fr);
String line = null;

while((line = br.readLine()) != null){
    System.out.println(line);
}