private Scanner getFileScanner () {

 Scanner user_input = new Scanner(System.in);
 String filepath = user_input.next();

 System.out.println("Filepath read: " + filepath);
 // Read input file
 Scanner input = new Scanner(new File(filepath));
 return input
}