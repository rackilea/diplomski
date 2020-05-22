public class PlayerModel {

    private static final int maxScore = 100;

    private static final String computerName = "Computer";

    private int numberOfRolls;
    private int score;
    private int tempScore;

    private String name;

    public PlayerModel(String name) {
        this.name = name;
        this.numberOfRolls = 0;
        this.score = 0;
        this.tempScore = 0;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }

    public int getScore() {
        return score;
    }

    public int getTempScore() {
        return tempScore;
    }

    public String getName() {
        return name;
    }

    public static int getMaxScore() {
        return maxScore;
    }

    public static String getComputerName() {
        return computerName;
    }

    public boolean addTempScore(int count) {
        if (count == 1) {
            this.tempScore = 0;
            this.numberOfRolls = 0;
            return false;
        } else {
            this.tempScore += count;
            this.numberOfRolls++;
            return true;
        }
    }

    public void addScore() {
        this.score += this.tempScore;
        this.tempScore = 0;
        this.numberOfRolls = 0;
    }

    public boolean isWinner() {
        return (getScore() >= maxScore);
    }

    public boolean isComputer() {
        return (getName().equals(computerName));
    }
}