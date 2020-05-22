StandardPieSectionLabelGenerator labelGen = new StandardPieSectionLabelGenerator(
            "{0} ({2})", new DecimalFormat("0"), new DecimalFormat("0%")) {

        @Override
        public String generateSectionLabel(PieDataset dataset, Comparable key) {
            if (key.equals("dormant")) {
                return null;
            }
            return super.generateSectionLabel(dataset, key);
        }

    };