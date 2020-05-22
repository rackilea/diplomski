while(scanFile.hasNextLine()) {
    String str = scanFile.nextLine().trim();  // trim off indents etc.

    // If the line is blank just read in the next line.
    if (str.equals("")) { continue; }

    // If this is a multi-line comment then
    if (str.startsWith("{") && !str.endsWith("}")) { 
        while(scanFile.hasNextLine()) {
            String commentStr = scanFile.nextLine().trim();
            str+= " " + commentStr;
            if (commentStr.endsWith("}")) { break; }
        }
    }

    // Do the rest of your processing....
    // ..................................
    // ..................................
}