public static void main(String s[]) {
        test.add("bot");
        test.add("ibot");
        test.add("abot");
        String str = "bot";

        for(int i=0;i<test.size();i++) {
            if(str.equals(test.get(i))) {
                System.out.println("True");
            }
            else {
                System.out.println("False");
            }
        }
    }