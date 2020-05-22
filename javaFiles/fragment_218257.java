public static void main(String[] args) {
        try {
            String s = " LITTLE RABBIT";
            s.trim().toUpperCase();
            int l = (s.length() - 1);
            int a = 0;
            char ch1, ch2;
            for (int i = 0; i < l; i++) {
                ch1 = s.charAt(i);
                ch2 = s.charAt(i + 1);
                if (ch1 == ch2) {
                    a++;
                }
            }
            System.out.println(a);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }