String text = userText.getText();
StringBuilder sb = new StringBuilder();
for (char c : text.toCharArray()) {
    sb.append(mapping.get(c)); //should add null check here
}

String encodedText = sb.toString();