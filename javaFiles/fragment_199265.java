public class Scientist {  
        private String name; 
        private String field;
        private String greatIdeas;

        public static void main(String[] args) {
            String scientists[] = new String[100];
            int scientistCount = 0;
            Scanner input = new Scanner(System.in);    

            do{
                String answer;
                System.out.println("Enter the name of the Scientist: ");          
                scientists[scientistCount]=input.nextLine();

                System.out.println(scientistCount);
                System.out.println("Would You like to add another Scientist?");
                scientistCount++;
            }

            while(input.nextLine().equalsIgnoreCase("Y"));
            input.close();
        }
    }