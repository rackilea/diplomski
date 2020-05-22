String  line = null;
StringBuilder sb = new StringBuilder("");

BufferedReader br = new BufferedReader("c:/path/yourfile.txt");
while ((line = br.readLine()) != null) {
    sb.append(line).append("\n");
}  
// you may probably need to remove the last '\n' before toString()

String fileContent = sb.toString();