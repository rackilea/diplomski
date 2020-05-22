public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {

    // DateTimeFormatter same as startDate and endDate
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    // total seconds elapsed at startDate
    // total seconds elapsed at endDate
    int startSeconds = startDate.toSecondOfDay();
    int endSeconds   = endDate.toSecondOfDay();

    // iterate through logLines
    for(Iterator<String> logLine = logLines.iterator(); logLine.hasNext(); ) {

        // split logLine into two strings: logDate, logDescription
        // store in string array `line`
        String[] line = logLine.next().split("\t");

        // int for storing amount of seconds from logDate
        int logDateSeconds;

        // try to parse logDate
        // catch generic exception to avoid parsing error
        try {

            // parse logDate using ISO_DATE_TIME formatter
            // get amount of seconds to compare to startSeconds and endSeconds
            logDateSeconds = LocalTime.parse(line[0], formatter).toSecondOfDay();

        } catch (Exception e) {

            // continue to next iteration for any Exception
            continue;

        }


        // compare amount of seconds to see if it is within time frame
        if (logDateSeconds >= endSeconds || logDateSeconds < startSeconds) {

            // remove iteration if it is not within time frame
            logLine.remove();
        }

    }

    // return edited 
    return logLines;

}