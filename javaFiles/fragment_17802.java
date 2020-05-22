String[][] splittedStringTwo = new String[splittedStringOne.length*2][2];

for(int i = 0; i < splittedStringTwo.length; i+=2){
    String[] split1 = splittedStringOne[i].split(",");
    String[] split2 = splittedStringOne[i+1].split(",");
    splittedStringTwo[i][0] = split1[0] 
    splittedStringTwo[i][1] = split2[0];
    splittedStringTwo[i+1][0] = split1[1]
    splittedStringTwo[i+1][1] = split2[1];
}