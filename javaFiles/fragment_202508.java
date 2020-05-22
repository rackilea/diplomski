while(scan.hasNextLine() && r < rows) {
   String line = scan.nextLine();
   char[] characters = line.    toCharArray();
   for (int i=0; i< characters.length; i=i+1{
        maze[r][i] = characters[i];
   }
   r++;
 }