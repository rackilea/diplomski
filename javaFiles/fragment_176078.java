// boolean to detect fist closing bracket
boolean firstClose = false;

int count = 0;
StringBuilder sb = new StringBuilder();
while(input.hasNextLine()) {
    String line = input.nextLine();           // get one line
    String newLine = "";                      // start newLine with 0 chars
    for (int i = 0; i < line.length(); i++) { // loop through chars in line
        char ch = line.charAt(i);
        if (ch == '{') {                      // if current char = '{'
            newLine += ch;                    // add '{' to newLine
            count++;                          // increase count
            newLine += count;

            firstClose = true;

        } else if (ch == '}') {    
            if (firstClose) {
                newLine += ch;
                newLine += count;
            } else {
                newLine += ch;                   
                count--;                          
                newLine += count;
                firstClose = false; 
            }              
        } else {
            newLine += ch;                    // else add char to newLine
        }
    }
    sb.append(newLine);                       // append newline to StringBuilder
    sb.append("\n");                          // append a next line char
}

PrintWriter writer = new PrintWriter(file);   
writer.print(sb.toString());                  // print the entire StringBuiler to file.
                                              // This this completely overwrite the
                                              // original file