if(morseText.charAt(i)==' '||i+1==morseText.length()) {
        for (int j = 0; j < 26; j++) {
            if(morsecodes[j].equals(morseLetter)) { //this is the if-statemen which causes the problem
                char c = (char)(j+97);
                realText += c;
            }

            if(j+1<=morseText.length()) {
                if(morseText.charAt(j)==' '&& morseText.charAt(j+1)==' ') {
                    realText += " ";
                }
            }
            //morseLetter = "";
        }
    }