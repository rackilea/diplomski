public static boolean sameTokens(String s1, String s2) {

    Scanner scan1 = new Scanner(s1);
    Scanner scan2 = new Scanner(s2);

    while(scan1.hasNext()||scan2.hasNext()){
        if ((!scan1.hasNext() && scan2.hasNext()) || (!scan2.hasNext() && scan1.hasNext())) {
            return false;
        } else {
            String token1 = scan1.next();
            String token2 = scan2.next();

            if (!token1.equals(token2)) {
                return false;
            }
        }
    }

    return true;
}