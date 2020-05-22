StringBuilder builder = new StringBuilder();
for (int i = 0; i < list.size(); i++) {
    builder.append(list.get(i));
    builder.append("whatever you want inbetween");
}
String output = builder.toString();