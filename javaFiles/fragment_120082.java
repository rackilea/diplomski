StringBuilder builder = new StringBuilder("<html>"); 
for (int i = 0; i < errorCache.size(); i++) {
    builder.append(errorCache.get(i));
    builder.append("<br>");
}
builder.append("</html>");
JOptionPane.showMessageDialog
    (null, builder.toString(), "Printing results", JOptionPane.INFORMATION_MESSAGE);