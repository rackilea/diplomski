String[] splittedStringTwo = new String[splittedStringOne.length*2];

for(int i = 0; i < splittedStringTwo.length; i+=2){
    String[] split = splittedStringOne[i].split(",");
    splittedStringTwo[i] = split[0];
    splittedStringTwo[i+1] = split[1];
}