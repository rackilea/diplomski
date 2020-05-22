public static void main(String[] args) {
        int i = 1;
        Scanner p = new Scanner(System.in);
        String g = p.next();
        int o = g.length();

        while (i <= o) {
            int q = o - i;
           // System.out.print(g.charAt(q));
            //System.out.print(q); - test line
            i++;
        }
    }