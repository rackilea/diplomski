String names = new String[numberOfLines];
int scores[][] = new int[numberofLines][2];
for(int i = 0;i < numberOfLines;i ++){
  String words[] = lines[i].split("\\s+");
  names[i] = words[0];
  scores[i][0] = Integer.parseInt(words[1]);
  scores[i][1] = Integer.parseInt(words[2]);
}