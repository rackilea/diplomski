...
        // Now, handle the other aspects like 
        //  quoting and scientific notation
        for(int i = 0; i < sb.length(); i++) {
           char c = sb.charAt(i);
/*
            // remove quotes and back slashes
            if (c == '\\' || c == '"') {
                sb.deleteCharAt(i);
                i--;
*/
            // handle quotes and back slashes
            if (c == '\\') {
                sb.setCharAt(i, '\'');
                sb.insert(i+2, '\'');
                i+=2;
            } else if (c == '"') {
                sb.setCharAt(i, '\'');
            // for scientific/engineering notation
            } else if (c == '+' && i > 0 && sb.charAt(i - 1) == 'E') {
                sb.deleteCharAt(i);
                i--;
            }
        }

        formatStr = sb.toString();
        formatStr = formatStr.replace("''", ""); 
        return formatStr;
    }
...