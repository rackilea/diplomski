private static final class Summary {
    private double salarySum;
    private double bonusSum;

    public Summary() {
        this.salarySum = 0;
        this.bonusSum = 0;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "salarySum=" + salarySum +
                ", bonusSum=" + bonusSum +
                '}';
    }
}