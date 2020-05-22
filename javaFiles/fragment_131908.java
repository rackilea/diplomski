DateTimeParser[] parsers = {
     DateTimeFormat.forPattern("E, d MMM y HH:mm:ss Z").getParser(),
     DateTimeFormat.forPattern("E, d MMM y HH:mm:ss Z '('z')'").getParser(),
     DateTimeFormat.forPattern("E, d MMM y HH:mm:ss z").getParser(),
     DateTimeFormat.forPattern("dd MMM y HH:mm:ss Z").getParser(),
 };