public static String getPersonality(int[] percentageB) {
    char [] lowPercentTypes =  {'E','S','T','J'};
    char [] highPercentTypes = {'I','N','F','P'};
    String MBTItype = "";
    for (int i = 0; i < lowPercentTypes.length; i++) {
        if (percentageB[i] < 50){
            MBTItype += lowPercentTypes[i];
        } else if (percentageB[i] > 50) {
            MBTItype += highPercentTypes[i];
        } else if (percentageB[i] == 50) {
            MBTItype += 'X';
        }
    }
    return MBTItype;
}