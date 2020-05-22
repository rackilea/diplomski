StringBuilder sb = new StringBuilder();
for (Node node : flow.getChildren()) {
    if (node instanceof Text) {
        sb.append(((Text) node).getText());
    }
}
String fullText = sb.toString();