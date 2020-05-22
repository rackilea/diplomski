public static void main(String[] args) {

    int NormCounter = 1;
    int ReplaceCounter = 0;

    for (int counter = 1; counter <= 300; counter++) {
        String NormCounterS  = NormCounter + ".";
        String ReplaceCounterS = ReplaceCounter + ".";

        Line = Line.replace(NormCounterS, ReplaceCounterS);

        ++ReplaceCounter;
        ++NormCounter;
    }

    System.out.println(Line);
}