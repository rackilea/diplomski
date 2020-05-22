private static String clearText(String input) {
    return input.replaceAll("\\D+", "");
}

private static UnaryOperator<Change> createPatternFilter(String pattern) {
    Pattern digitsPattern = Pattern.compile("\\d*");
    final int maxDigits = pattern.replaceAll("[^#]*", "").length();
    return change -> {
        String text = change.getText();
        if (!digitsPattern.matcher(text).matches()) {
            return null; // prevent inputs other than digits
        }
        if (change.getControlText().equals(change.getControlNewText())) {
            return change; // allow all changes not modifying the text
        }

        String clearText = clearText(change.getControlNewText());
        String clearPrefix = clearText(change.getControlNewText().substring(0,  change.getAnchor()));
        final int prefixLength = clearPrefix.length();
        if (clearText.length() > maxDigits) {
            if (prefixLength > maxDigits) {
                return null; // cursor already positioned after the last digit placeholder
            }
            clearText = clearText.substring(0, maxDigits); // cut of excessive digits
        }
        StringBuilder resultText = new StringBuilder(pattern.length());
        int index = 0;
        int prefixIndex = 0;

        // copy parts digits before the cursor
        while (prefixIndex < prefixLength) {
            char c = pattern.charAt(index);
            if (c == '#') {
                resultText.append(clearPrefix.charAt(prefixIndex));
                prefixIndex++;
            } else {
                resultText.append(c);
            }
            index++;
        }

        // deal with following non-digit placeholders
        char c;
        while (index < pattern.length() && (c = pattern.charAt(index)) != '#') {
            resultText.append(c);
            index++;
        }

        int newAnchor = resultText.length();
        String clearSuffix = clearText.substring(prefixLength);
        int suffixIndex = 0;

        // copy remaining digits
        while (index < pattern.length() && suffixIndex < clearSuffix.length()) {
            c = pattern.charAt(index);
            if (c == '#') {
                resultText.append(clearSuffix.charAt(suffixIndex));
                suffixIndex++;
            } else {
                resultText.append(c);
            }
            index++;
        }

        resultText.append(pattern.substring(index));
        change.setRange(0, change.getControlText().length());
        change.setText(resultText.toString());
        change.selectRange(newAnchor, newAnchor);

        return change;
    };
}

@Override
public void start(Stage primaryStage) {
    String pattern = "(###) ###-####";
    TextField tf = new TextField(pattern);
    TextFormatter<String> formatter = new TextFormatter<>(createPatternFilter(pattern));
    tf.setTextFormatter(formatter);

    VBox content = new VBox(tf);

    Scene scene = new Scene(content);
    primaryStage.setScene(scene);
    primaryStage.show();
}