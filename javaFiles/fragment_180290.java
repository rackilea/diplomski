Scanner sc = new Scanner(System.in);
String answer = null;
boolean ask_again = true;
do {
     System.out.println("Your final answer is? (Y/N)");
     answer = sc.next();
     if(answer.equals("Y")){
       //do something when Yes
       ask_again = false;
     }
     else if(answer.equals("N")){
       //do something when No
       ask_again = false;
     }
     else {
       ask_again = true; 
     }
} while(ask_again == true);