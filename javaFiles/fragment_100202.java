package main;

    import java.util.Scanner;

    public class Main {

        private static Scanner input;
        private static Garage gar;
        private static Attendant currentUser;
        private static boolean isManager;

        public static void main(String[] args) {
            input = new Scanner(System.in);
            gar = new Garage(10, 80, 10);
            currentUser = null;
            while (currentUser == null)
                logIn();
        }

        public static void logIn() {
            System.out.println("Enter username: ");
            String userN = input.nextLine();
            System.out.println("Enter password:");
            String userP = input.nextLine();
            //if no username, go back
            if(gar.getAccount(userN) == null) { 
                error("Incorrect username");
                return;
            } 
            if(gar.getAccount(userN).getPassword().equals(userP) == false) { //if entered password doesn't match
                error("Incorrect password");
                return;
            } 
            currentUser = gar.getAccount(userN);
            return;
        }

        //update to throw error pop-up later
        public static void error(String er) { System.out.println(er); }
    }