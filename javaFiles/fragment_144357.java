public class ScoreExample {

    public static void main(String[] args) {
        List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
        scoreList.add(new ScoreVO("A", 50));
        scoreList.add(new ScoreVO("C", 50));
        scoreList.add(new ScoreVO("B", 500));
        Collections.sort(scoreList);
        assignRank(scoreList);
        System.out.println("Score List: "+scoreList);
    }

    private static void assignRank(List<ScoreVO> scoreList) {
        int rank = 0;
        int score = 0;
        for(ScoreVO scoreVO : scoreList) {
            if(score != scoreVO.getPlayerScore()) {
                rank++;
                scoreVO.setPlayerRank(rank);
                score = scoreVO.getPlayerScore();
            } else {
                scoreVO.setPlayerRank(rank);
            }
        }
    }
}
class ScoreVO implements Comparable<ScoreVO> {
    public String playerName;
    public int playerScore;
    public int playerRank;

    public ScoreVO(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }

    @Override
    public int compareTo(ScoreVO o) {
        if(o.getPlayerScore() != getPlayerScore()) {
            if(getPlayerScore() > o.getPlayerScore())
                return -1;
            else
                return 1;
        } 
        return getPlayerName().compareTo(o.getPlayerName());
    }

    @Override
    public String toString() {
        return "ScoreVO [playerName=" + playerName + ", playerScore="
                + playerScore + ", playerRank=" + playerRank + "]";
    }
}