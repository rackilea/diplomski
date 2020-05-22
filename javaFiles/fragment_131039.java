StringBuilder builder = new StringBuilder();
for (String value : employeeRecords.get(row)) {
    builder.append(value);
}
String text = builder.toString();
employeeDisplay.setText(text);