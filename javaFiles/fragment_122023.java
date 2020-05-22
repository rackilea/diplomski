int i = 0;
String line = null;
String[] lines = new String[10];

// read the next line and immediately check to see if it's null
// also make sure that i doesn't go out of range
while ((line = input.readLine()) != null
    && i < lines.length) {
    lines[i] = line;

    // Use .equals() (not ==) when comparing strings!
    if ("foo".equals(line)) {
        i++; // shorter form of i=i+1
        lines[i] = "lineAfterFoo";
    }
    i++;
}