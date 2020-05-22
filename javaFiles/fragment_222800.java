StringBuffer s = new StringBuffer();
char c;
loop-through-characters {
    if(c == '\n') {
        // Replace new-line with "\n".
        s.append("\\n");
    } else if(c == '\r') {
        // Replace line-feed with "\r".
        s.append("\\r");
    } else if(c == '\t') {
        // Replace tab with space " ".
        s.append(" ");
    } else {
        // Otherwise, append the character as-is.
        s.append(c);
    }
}

// Process the bytes[] in StringBuffer s as you would have 
// previously processed the raw bytes[].