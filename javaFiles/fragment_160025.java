public class Formula {
    private final String label;
    private final String deAccentedLabel;

    public Formula(String label) {
        this.label = label;
        this.deAccentedLabel = deAccent(label);
    }

    public String getLabel() {
        return label;
    }

    public String getDeAccentedLabel() {
        return comparableLabel;
    }


    private String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

}