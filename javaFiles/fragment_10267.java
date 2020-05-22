Scanner scan = new Scanner(System.in);

String response;

do { 

    System.out.print("Would you like to search by (1) Title or (2) Lexile # : ");
    response = scan.nextLine();   

} while(!response.equals("1") && !response.equals("2"));

int choice = Integer.parseInt(response);

try {
    System.out.print("Say cheeseeeee...");
    Thread.sleep(3000);
} catch(InterruptedException e){
    // handle exception
    e.printStackTrace();
}

System.out.println("\nChoice : " + choice);