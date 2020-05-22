StringBuffer fullLine = new StringBuffer();

while ((currentLine = reader.readLine()) != null) {
    int tagStartIndex = currentLine.indexOf(openTag, 0);
    int tagEndIndex = currentLine.indexOf(closeTag, tagStartIndex);

    // both tags on the same line
    if (tagStartIndex != -1 && tagEndIndex != -1) {
        // process the whole line
        tempList.add(currentLine);
        fullLine = new StringBuffer();
    // no tags on this line but the buffer has been started
    } else if (tagStartIndex == -1 && tagEndIndex == -1 && fullLine.length() > 0) {
        /*
         * add the current line to the buffer; it is part 
         * of a larger line
         */
        fullLine.append(currentLine);
    // start tag is on this line
    } else if (tagStartIndex != -1 && tagEndIndex == -1) {
        /*
         *  line started but did not have an end tag; add it to 
         *  a new buffer
         */
        fullLine = new StringBuffer(currentLine);
        // end tag is on this line
    } else if (tagEndIndex != -1 && tagStartIndex == -1) {
        /*
         *  line ended but did not have a start tag; add it to 
         *  the current buffer and then process the buffer
         */
        fullLine.append(currentLine);
        tempList.add(fullLine.toString());
        fullLine = new StringBuffer();
    }
}