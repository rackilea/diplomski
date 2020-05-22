public static void included(ArrayList <Object> list) {

        StringBuilder s = new StringBuilder(list.toString()) ;
        System.out.println("BEFORE:");
        System.out.println(s);
        for (int i = 1; i < s.length(); ++i) {
            if ( s.charAt(i) == '[' ||s.charAt(i) == ']') {
                s.deleteCharAt(i);
            }
        }

        System.out.println("AFTER:");
        System.out.println(s);
}



    public static void included(ArrayList <Object> list,int size) {

        StringBuilder s = new StringBuilder(list.toString()) ;
        System.out.println("BEFORE:");
        System.out.println(s);
        int includeArrRight=0;
        int includeArrLeft=0;

            for (int i = 1; i <s.length(); i++) {
                if (s.charAt(i) == '[' && includeArrLeft < size) {
                    s.deleteCharAt(i);
                    includeArrLeft++;
                }

                if (s.charAt(i) == ']' && includeArrRight < size) {
                    s.deleteCharAt(i);
                    includeArrRight++;
                }
            }

        System.out.println("AFTER:");
        System.out.println(s);

        }