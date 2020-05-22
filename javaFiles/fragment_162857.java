//split it by newline, should work on windows/unix
String lines[] = str.split("\\r?\\n");  
char[][] map = new char[lines.length][];
//fill up map, each row is a new line
for(int i = 0; i < lines.length; i ++)
map[i] = lines[i].toCharArray();
//map[0][2] returns 'z'