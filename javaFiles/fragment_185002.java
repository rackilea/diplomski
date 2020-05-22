public static List<String> splitSSV(String in) throws IOException {
        ArrayList<String> out = new ArrayList<String>();

        StringReader r = new StringReader(in);
        StringBuilder b = new StringBuilder();
        int inQuote = -1;
        boolean escape = false;
        int c;
        // read each character
        while ((c = r.read()) != -1) {
            if (escape) {  // if the previous char is escape, add the current char
                b.append((char)c);
                escape = false;
                continue;
            }
            switch (c) {
            case '\\':   // deal with escape char
                escape = true;
                break;
            case '\"':
            case '\'':  // deal with quote chars
                if (c == '\"' || c == '\'') {
                    if (inQuote == -1) {  // not in a quote
                        inQuote = c;  // now we are
                    } else {
                        inQuote = -1;  // we were in a quote and now we aren't
                    }
                }
                break;
            case ' ':
                if (inQuote == -1) {  // if we aren't in a quote, then add token to list
                    out.add(b.toString());
                    b.setLength(0);
                } else {
                    b.append((char)c); // else append space to current token
                }
                break;
            default:
                b.append((char)c);  // append all other chars to current token
            }
        }
        if (b.length() > 0) {
            out.add(b.toString()); // add final token to list
        }
        return out;
    }