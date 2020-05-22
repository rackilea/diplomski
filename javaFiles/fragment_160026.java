public class Formula {
    private final String label;
    private final String comparableLabel;

    public Formula(String label) {
        this.label = label;
        this.comparableLabel = deAccent(label).toLowerCase();
    }

    public String getLabel() {
        return label;
    }

    private String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static Comparator<Formula> getLabelComparator() {
        return (formula1, formula2) -> formula1.comparableLabel.compareTo(formula2.comparableLabel);
    }

}