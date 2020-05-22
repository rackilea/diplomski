String text = textArea.getText();

// capture everything except the last word into group 1
Pattern regex = Pattern.compile("(.*?)\\w+\\s*\\Z", Pattern.DOTALL);
Matcher matcher = regex.matcher(text);

if (matcher.find()) {
    text = matcher.group(1);
    textArea.setText(text);
}