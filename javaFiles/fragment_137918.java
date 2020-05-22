DefaultListModel<String> model = new DefaultListModel<>();

StringBuilder builder = new StringBuilder();

builder.append("<html><pre>");
builder.append(String.format("%s \t %s \t %s", "str1", "str2", "str3"));
builder.append("</pre></html>");

model.addElement(builder.toString());