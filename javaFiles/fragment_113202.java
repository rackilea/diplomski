public class MatchResult {
    private final int firstTeamScore;
    private final int secondTeamScore;

    public MatchResult(final int firstTeamScore, final int secondTeamScore) {
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
    }

    public int getFirstTeamScore() {
        return firstTeamScore;
    }

    public int getSecondTeamScore() {
        return secondTeamScore;
    }

    public String getResultForFirstTeam() {
        if (firstTeamScore > secondTeamScore) {
            return "Win"; // In an actual implementation, I would replace this with an enum
        } else if(firstTeamScore = secondTeamScore) {
            return "Tie";
        } else {
           return "Lose";
        }
    }
    // You can add a method public String getResultForSecondTeam(), I omitted it for brevity
}