if (ch >= 'a' && ch <= 'z' || ch == ' ') {
            replacementCh = ch;
        } else if (ch >= 'A' && ch <= 'Z') {
            replacementCh = Character.toLowerCase(ch);
        }
        else {
            replacementCh = 0; 
        }