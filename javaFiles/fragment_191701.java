String sequence = "0001112122";
for(int i=0; i+3<sequence.length(); i+=2){
    int currx = Character.getNumericValue(sequence.charAt(i));
    int curry = Character.getNumericValue(sequence.charAt(i+1));
    int finalX = Character.getNumericValue(sequence.charAt(i+2));
    int finalY = Character.getNumericValue(sequence.charAt(i+3));
    goTo(finalX, finalY, currx, curry);
}