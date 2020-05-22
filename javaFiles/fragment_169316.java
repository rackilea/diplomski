public class TeamStatistic {

    private String teamName;
    private int numberWin;
    private int numberDraw;
    private int numberLoss;
    private int matchesPlayed;
    private int points;
    private int goalsScored;
    private int goalsConceded;
    private int tablePosition;

    public TeamStatistic(String teamName, int numberWin, int numberDraw, int numberLoss, int matchesPlayed, int points, int goalsScored, int goalsConceded, int tablePosition) {
        this.teamName = teamName;
        this.numberWin = numberWin;
        this.numberDraw = numberDraw;
        this.numberLoss = numberLoss;
        this.matchesPlayed = matchesPlayed;
        this.points = points;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.tablePosition = tablePosition;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getNumberWin() {
        return numberWin;
    }

    public void setNumberWin(int numberWin) {
        this.numberWin = numberWin;
    }

    public int getNumberDraw() {
        return numberDraw;
    }

    public void setNumberDraw(int numberDraw) {
        this.numberDraw = numberDraw;
    }

    public int getNumberLoss() {
        return numberLoss;
    }

    public void setNumberLoss(int numberLoss) {
        this.numberLoss = numberLoss;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(int tablePosition) {
        this.tablePosition = tablePosition;
    }

    @Override
    public String toString() {
        return "TeamStatistic{" +
                "teamName='" + teamName + '\'' +
                ", numberWin=" + numberWin +
                ", numberDraw=" + numberDraw +
                ", numberLoss=" + numberLoss +
                ", matchesPlayed=" + matchesPlayed +
                ", points=" + points +
                ", goalsScored=" + goalsScored +
                ", goalsConceded=" + goalsConceded +
                ", tablePosition=" + tablePosition +
                '}';
    }
}