protected int findOptionByIgnoreCaseText(String value, Select dropDown) {
    int index = 0;
    for (WebElement option : dropDown.getOptions()) {
        if (Normalizer.normalize(option.getText(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").trim()
                .equalsIgnoreCase(Normalizer.normalize(value, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").trim())) {
            return index;
        }
        index++;
    }
    return -1;
}