private Scanner scan;
 private Scanner keyboard = new Scanner(System.in);

   public Maze (File filename){
      // Scanner scan; This line is def. not necessary
      try{
         scan = new Scanner(filename);
      }
      catch(FileNotFoundException e){
         System.out.println ("File not found");
         return;
      }
      rows = keyboard.nextInt();
      cols = keyboard.nextInt();
      maze = new String[rows][cols];
      startX = keyboard.nextInt();
      startY = keyboard.nextInt();
      for (int i = 0; i < rows; i++){
         String temp = scan.next();
         for (int j = 0; j < cols; j++){
            maze[i][j] = "" + temp.charAt(j);
         }
         scan.close();
         keyboard.close();
      }
   }