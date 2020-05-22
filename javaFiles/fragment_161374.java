List<String> checkboxValues = new ArrayList<String>(); 

// ... while looping over all items.

String fieldname = item.getFieldName();
String fieldvalue = item.getString();

if ("checkboxName".equals(fieldname)) {
    checkboxValues.add(fieldvalue);
}

// ... after looping over all items.

StringBuilder builder = new StringBuilder();

for (String checkboxValue : checkboxValues) {
    if (builder.length() > 0) builder.append(";");
    builder.append(checkboxValue);
}

String semicolonSeparatedCheckboxValues = builder.toString();
// Save in DB. By the way, why not just using a separate table with a FK?
// Storing multiple values delimited in a single DB column is a bad practice.