String dFormat = "EEEE, MMMM d, yyyy",
       tFormat = "KK:mm a";

public String formatInterval(Date from, Date to) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dFormat),
                     timeFormat = new SimpleDateFormat(tFormat);

    StringBuilder s = new StringBuilder();
    // Day
    s.append(dateFormat.format(from));
    s.append(' ');
    // Start time
    s.append(timeFormat.format(from));
    s.append(" - ");
    // End time
    s.append(timeFormat.format(to));
    return s.toString();
}

public String formatInterval(Calendar from, Calendar to) {
    return formatInterval(from.getTime(), to.getTime());
}