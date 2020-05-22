class HighScore {

    public final int score;
    public final String name;
    private HighScore(int scoreP, int nameP) {
        score = scoreP;
        name = nameP;
    }

    public String toString() {
        return score + "  " + name;
    }

    public static HighScore fromLine(String line) {
        String[] parts = line.split(" +");
        return new HighScore(Integer.parseInt(parts[0].trim()), parts[1].trim());
    }
}