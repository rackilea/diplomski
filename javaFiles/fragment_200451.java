public class PlayerScoresComparator implements Comparator<PlayerScores> {
    @Override
    public int compare(PlayerScores lhs, PlayerScores rhs) {
        return lhs.points - rhs.points;
    }
}