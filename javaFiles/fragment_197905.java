public FileReader fr = new FileReader("path/to/your/file");
public BufferedReader br = new BufferedReader(fr);
String playerName = "John";
String line;
List<String> playerInfo = new ArrayList<String>();
while((line =  br.readLine()) != null){
 if (line.contains(playerName))
 {
    int numLines = 7;
    playerInfo.add(line);
    while((line =  br.readLine()) != null && numLines >= 1){
        playerInfo.add(line);
        numLines --;
        break;
    }
    break;
 }
}