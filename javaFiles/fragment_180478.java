public static enum Grade {

    // Letter grades are A, B, C, D, and F
    // Their numeric values are 4, 3, 2, 1, and 0

    A(4),B(3),C(2),D(1),F(0);

    public final double score;

    private Grade(double d) {
        this.score = d;
    }

    // Grades are possibly followed by + or –
    // There is no F+ or F–
    // a + increases the numeric value by 0.3, a – decreases it by 0.3
    // However, an A+ has value 4.0

    public double getModifiedScore(char sign) {
        switch (sign) {
            case '+':
                return score + (score < 4 && score > 0 ? 0.3 : 0);
            case '-':
                return score + (score > 0 ? -0.3 : 0);
            default:
                throw new IllegalArgumentException("Invalid sign");
        }
    }
}