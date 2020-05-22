static class CustomLegendGenerator
        implements PieSectionLabelGenerator {

    public String generateSectionLabel(final PieDataset dataset, final Comparable key) {
        String temp = null;
        if (dataset != null) {
            temp = key.toString();
            if (key.toString().equalsIgnoreCase("abc")) {
                temp = temp + " (abc String)";
            }
            if (key.toString().equalsIgnoreCase("xyz")) {
                temp = temp + " (xyz description)";
            }
            if (key.toString().equalsIgnoreCase("klm")) {
                temp = temp + " (Klm description)";
            }
        }
        return temp;
    }

    public AttributedString generateAttributedSectionLabel(PieDataset pd, Comparable cmprbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}