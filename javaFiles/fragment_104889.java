if (charNum >= ansString.length()) {
                bArray[num][2] += 1;
            } else if (ansString.charAt(charNum) == ' ') {
                bArray[num][2] += 1;
            } else if (ansString.charAt(charNum) == corrAns.charAt(charNum)) {
                bArray[num][0] += 1;
            } else {
                bArray[num][1] += 1;
            }