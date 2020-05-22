int charToIndex(char c) {
       char upper = Character.toUpperCase(c);
       if(upper >= 'A' && upper <= 'Z') {
           // returns 1 for 'A' ... 26 for 'Z'
           return (upper - 'A') + 1;
       }
       if(upper >= '0' && upper <= '9') {
           // returns 27 for '0' ... 37 for '9'
           return 27 + (upper - '0');
       }
       return 0; // meaning 'other'
  }