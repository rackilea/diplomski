int[] numbers = new int[splitLine.length];
for(int i = 0; i< line.length(); i++){
    try{
        numbers[i] = Integer.parseInt(splitLine[i]);
    }catch(NumberFormatException nfe){};
}