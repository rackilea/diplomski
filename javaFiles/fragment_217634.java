public String separate(int n, String linePart) {
    StringBuilder finLine = new StringBuilder(linePart);
    int lines_added = 0;
    for (i = 0; i < finLine.length(); i++) {  //inspects each character in string.
        c = finLine.charAt(i);

        if (c == ' ') {                          //determines whether or not char is a space
            if (cCount == n ) {                  //checks char count
                finLine.replace(i, i+1, System.lineSeparator());   //adds new line if char count is reached right before space.
                cCount = 0;
                lastSpc = i ;
            }
            else {
                lastSpc = i;                     //assigns index to variable so no need to reverse through string.
            }
        }
        else {
            cCount++;
            if (cCount == n) {                      //if char count is reached while inspecting letter, 
                finLine.replace(lastSpc, lastSpc+1, System.lineSeparator());      //replaces last space with new line char
                cCount = i - lastSpc;
            }
        }
    }
    return finLine.toString();
}