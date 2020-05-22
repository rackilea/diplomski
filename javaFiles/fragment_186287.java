public class RockPaperScissorsClass {

    private int wins;
    private int losses;
    private int ties;
    private int CChoice;
    private int PChoice;

    public RockPaperScissorsClass() {
        this(0, 0, 0, 0, 0);
    }

    public RockPaperScissorsClass(int wins, int losses, int ties, int computerPick, int playerPick) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.CChoice = computerPick;
        this.PChoice = playerPick;
    }

    public void setPlayer(int p) {
        CChoice = p;
    }

    public String getPlayer() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Choice(1=Rock, 2=Paper, 3=Scissors)-->");
        int PPChoice = in.nextInt();
        String PChoice = null;
        if (PPChoice == 1) {
            this.PChoice = 1;
            PChoice = "Rock";
        } else if (PPChoice == 2) {
            this.PChoice = 2;
            PChoice = "Paper";
        } else if (PPChoice == 3) {
            this.PChoice = 3;
            PChoice = "Scissors";
        } else {
            while (true) {
                System.out.println("You have entered an invalid choice. Please try again.");
                System.out.println("Enter Choice(1=Rock, 2=Paper, 3=Scissors)-->");
                PPChoice = in.nextInt();
                if (PPChoice == 1) {
                    PChoice = "Rock";
                    break;
                } else if (PPChoice == 2) {
                    PChoice = "Paper";
                    break;
                } else if (PPChoice == 3) {
                    PChoice = "Scissors";
                    break;
                }
            }
        }
        return PChoice;
    }

    public String getComputer() {
        Random rand = new Random();
        int CCChoice = rand.nextInt(3) + 1;
        System.out.println(CCChoice);
        String CChoice = null;
        if (CCChoice == 1) {
            this.CChoice = 1; 
            CChoice = "Rock";
        } else if (CCChoice == 2) {
            this.CChoice = 2;
            CChoice = "Paper";
        } else if (CCChoice == 3) {
            this.CChoice = 3;

            CChoice = "Scissors";
        }
        return CChoice;
    }

    public String determineWinner() {
        String detWinner = "";
        if (PChoice == 1 && CChoice == 2) {
            detWinner = "You Lose";
        } else if (PChoice == 1 && CChoice == 3) {
            detWinner = "You Win";
        } else if (PChoice == 2 && CChoice == 3) {
            detWinner = "You Lose";
        } else if (PChoice == 2 && CChoice == 1) {
            detWinner = "You Win";
        } else if (PChoice == 3 && CChoice == 1) {
            detWinner = "You Lose";
        } else if (PChoice == 3 && CChoice == 2) {
            detWinner = "You Win";
        } else if (PChoice == 1 && CChoice == 1) {
            detWinner = "You Have Tied";
        } else if (PChoice == 2 && CChoice == 2) {
            detWinner = "You Have Tied";
        } else if (PChoice == 3 && CChoice == 3) {
            detWinner = "You Have Tied";
        }

        return detWinner;

    }

    public static void main(String[] args) {
        RockPaperScissorsClass rc = new RockPaperScissorsClass();
        System.out.println("Player is: " + rc.getPlayer());
        System.out.println("Computer is: " + rc.getComputer());
        System.out.println(rc.determineWinner());
    }
}