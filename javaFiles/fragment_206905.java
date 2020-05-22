while((line=br.readLine())!=null) {
    String[] columns = line.split(" ");
    if( columns != null && columns.length >= 5 ) {
        sum = sum + Integer.parseInt(columns[4]);
    }
    else {
        // do what you must here; it may be an error to encounter such a line:
        throw new IllegalArgumentException("malformatted line: " + line);
        // or it may be OK to swallow the exceptional case
        // or you may only need to silently log it:
        logger.warn("malformatted line: " + line);
        // etc...
    }
}