while (k < 4) {
        for (int j = 1; j <= 13; j++) {
            Hashtable<Integer, String> Deck = new Hashtable();
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            while (cnt++ != 10) {
                int myChar = (int) (Math.random() * str.length());
                sb.append(str.charAt(myChar));
            }
            int i = (int) (Math.random() * 52);
            Deck.put(i, sb.toString());
            System.out.print(Deck);
        }

        System.out.println();
        k++;
    }