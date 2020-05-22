final String fullText = textArea.getText();
final int width = textArea.size.width;
final ArrayList lines = new ArrayList();
final FontMetrics fontMetrics = textArea.getGraphics().getFontMetrics(textArea.getFont());

StringBuilder sb = new StringBuilder(); 
for(final Character c : fullText) {
    sb.append(c);
    if(fontMetrics.stringWidth(sb.toString()) > width) { 
        sb.setLength(sb.length() - 1); 
        lines.add(sb.toString()); 
        sb = new StringBuilder(c.toString()); 
    }
}
lines.add(sb.toString());