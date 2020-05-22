public static void main(String args[]){
  Scanner sc = new Scanner(System.in);
  while(true){ //keep running till we break

    System.out.println("Enter filename or return blank line to quit");
    String fileName = sc.nextLine();

    if(fileName != null && !fileName.isEmpty()){ 
      processFile(fileName)
    }else{
      break; //no user input => exit
    }
  }
  System.out.println("bye");
}

private static processFile(String fileName){
    String hteam;
    String ateam;
    int hscore;
    int ascore;
    int totgoals = 0;

    Scanner s = new Scanner(new BufferedReader(
            new FileReader(fileName))).useDelimiter("\\s*:\\s*|\\s*\\n\\s*");

    while (s.hasNext()) {
      … //rest of your original code
}