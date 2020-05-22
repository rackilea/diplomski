import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    public class IssueTrackingObject {
        Scanner input = new Scanner(System.in);
        // Make your issues lists members of the class so that they
        // can be accessed from all the methods inside the class
        private List<String> _allIssues = new ArrayList<String>();
        // Added a Solved issues list to store the solved issues
        private List<String> _solvedIssues = new ArrayList<String>();

        public void createIssue() {
            System.out.println("Enter the number of issues you will  enter: ");
            int length = input.nextInt();
            for (int counter = 0; counter < length; counter++) {
                System.out.printf("Enter issue number %d\n", counter + 1);
                _allIssues.add(input.next());
            }
            System.out.println("Your issues are: ");
            for (int counter = 0; counter < _allIssues.size(); counter++) {
                System.out.printf("%d. %s\n", counter + 1, _allIssues.get(counter));
            }
        }

        void solvedIssue() {
            if(_allIssues.size() == 0) {
                System.out.println("No issues entered yet. Please enter some issues");
                return;
            }
            System.out.println("To MARK an issue as solved, please enter the number of the issue: ");
            int index = input.nextInt();
            --index; // List starts at zero
            _solvedIssues.add(_allIssues.get(index));
            _allIssues.remove(index);
        }

        void printSolvedIssue() {
            System.out.println("You have SOLVED the following issues: ");
            for(int i = 0; i < _solvedIssues.size(); ++i) {
                System.out.printf("%d. %s\n", i + 1, _solvedIssues.get(i));
            }
        }

        void printUnsolvedIssue() {
            System.out.println("Your unsolved Issues are: ");
            for(int i = 0; i < _allIssues.size(); ++i) {
                System.out.printf("%d. %s\n", i + 1, _allIssues.get(i));
            }
        }

        public static void main(String[] args) {
            int exit = 1;
            Scanner input = new Scanner(System.in);
            IssueTrackingObject itracker = new IssueTrackingObject();
            while(exit != -1) {
                System.out.println("Select an Option or -1 to exit\n1. Create Issue\n2. Solve Issue\n"
                                  + "3. View solved issues\n4. View unsolved issues");
                exit = input.nextInt();
                switch (exit) {
                case(0) :
                    System.out.println("Number of issues has to be greater than zero");
                break;
                case(1) :
                    itracker.createIssue();
                break;
                case(2) :
                    itracker.solvedIssue();
                break;
                case(3) :
                    itracker.printSolvedIssue();
                break;
                case(4) :
                    itracker.printUnsolvedIssue();
                break;
                }

            }
            input.close();
            System.out.println("Program finished");
        }
    }