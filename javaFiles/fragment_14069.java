HtmlCleaner cleaner = new HtmlCleaner();
TagNode root= cleaner.clean(...);
TagNode[] trNodes= root.getElementsByName("tr");
for (TagNode trNode : trNodes) {
    System.out.println("All text inside this <tr> tag (including children): " + trNode.getText());
}