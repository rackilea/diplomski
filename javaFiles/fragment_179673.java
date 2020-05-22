public static void main(String[] args) {
    String myString = "a:10,b:15,c:20,d:30";
    String mixedString[] = myString.split(":|\\,");
    String requiredArray1[] = new String[mixedString.length];
    int requiredArray2[] = new int[mixedString.length];
    int s = 0;
    int n = 0;
    for (int i = 0; i < mixedString.length; i++) {
        if (!test(mixedString[i])) {
            requiredArray1[s] = mixedString[i];
            s++;
        } else {
            requiredArray2[n] = Integer.parseInt(mixedString[i]);
            n++;
        }
    }
}

public static boolean test(String s) {
    try {
        Integer i = Integer.parseInt(s);
        return true;
    } catch (Exception e) {
        return false;
    }
}