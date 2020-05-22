private boolean quitCommand = false;
 private void runIt() {       
     BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
     String input = null;

     while(!quitCommand) {
         try {   
             System.out.print("Give a command: ");
             input = is.readLine();

             // As long as the command isn’t to quit:
             if(input == null || "quit".equals(input.trim())) quitCommand = true;
             if(quitCommand) break;

             // get the next input line and handle it. (With handleCommand.)
             String[] words = input.trim().split("\\s+");

             // ** This is the original handleCommand line **
             System.out.println(input + ":" + Arrays.toString(words));
         } 
         catch (Exception e) {
             System.out.println("Something went wrong we are sorry try again.");
             e.printStackTrace();
         }
     }
 }