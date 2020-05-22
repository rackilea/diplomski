for (int line = 0; line <= 5; line++)
    {
        for (int i = 0; i < combine.length; i++) {
            Stack st = combine[i];
            if (st.size() > line) {
                System.out.print(st.get(line) + "  ");
            } else {
                System.out.print("           ");
            }
        }
        System.out.println();
    }