String line="";
      int n=0;
      while(fileName.hasNextLine()){
        line = fileName.nextLine();
        n++;
      }
      int m = line.length();
      boolean[][] cells = new boolean[n][m];
      // initialize Scanner to read file again
      Scanner in = new Scanner(new File("C:/Users/USER/Desktop/hashtag.txt"));
      int i=0;
      while(in.hasNextLine()){
            line = in.nextLine();
        for(int j=0; j < line.length(); j++){
            char c = line.charAt(j);    
            if(c == '#'){
                cells[i][j] = true;
            }
            else{
                cells[i][j] = false;
            }
        }
        i++;
     }