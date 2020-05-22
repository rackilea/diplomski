String file = ""; // Basically, a conglomerate of all of the lines in the file
while ((line = r.readLine()) != null) {
    file += line; // Append each line to the "file" string
}
Matcher matcher = patt.matcher(file);
while (matcher.find()) {
    /* Blah blah blah, your outputting goes here. */
}