String answer = "";
Scanner sc = new Scanner(System.in);    
do {
    while(answer.equals("")) {
        answer = sc.nextLine();
    }
    if(!answer.equals("y") && !answer.equals("n")) {
        System.out.println("Please enter a y, meaning yes; or an n, meaning no.");
        answer = "";
    }
}while (!answer.equals("y") && !answer.equals("n"));