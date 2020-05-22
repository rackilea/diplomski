//filename is filepath string
BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
String line;
StringBuilder sb = new StringBuilder();

while((line=br.readLine())!= null){
    sb.append(line.trim());
}