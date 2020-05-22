// dynamic list of strings for dates and messages
List<String> dates = new ArrayList<>();
List<String> messages = new ArrayList<>();
// split your logfile by line
String[] lines = yourLogFileContentAsString.split("\n");
for (String line : lines) {
    // dates are characters 0-19
    dates.add(line.substring(0, 20));
    // message starts at character 21
    messages.add(line.substring(21);
}
// you wanted arrays
String[] datesArray = dates.toArray(new String[0]);
String[] messagesArray = messages.toArray(new String[0]);