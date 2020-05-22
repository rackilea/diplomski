public void run() {

    String text = textField.getText();
    Pattern pattern = Pattern.compile("_[0-9]+");
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
        // get the init string (e.g. "_42")
        String group = matcher.group();
        // parse it as an int (i.e. 42)
        int number = Integer.valueOf(group.substring(1));
        // replace all "_42" with the result of getSubscript(42)
        text = text.replaceAll(group, getSubscript(number));
        // recompile the matcher (less iterations within this while)
        matcher = pattern.matcher(text);
    }

    textField.setText(text);

}