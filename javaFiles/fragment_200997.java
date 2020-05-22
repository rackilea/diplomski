DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy")
List<String> lines = readLines(); // use a function of your to read the lines
List<LogEntry> entries = new LinkedList<LogEntry>();
for ( String line : lines ) {
  int splitIndex = line.indexOf("<log>");
  String time = line.substring(0,splitIndex);
  Date date = dateFormat.parse(time);
  entries.add(new LogEntry(date,line.substring(splitIndex));
}

Collections.sort(entries);


// create a class to hold the log contents and the timestamp

class LogEntry implements Comparable<LogEntry> {
    private final Date time;
    private final String entry;

    public void compare(LogEntry other) {
       return time.compareTo(other.time);
    }
}