`
    boolean[] counter = new boolean[256];
    StringBuilder sb = new StringBuilder(input);
    for (int i = 0; i < sb.length(); i++) {
        if (counter[(int) input.charAt(i)]) {
            sb.setCharAt(i, ' ');
        }
        counter[(int) input.charAt(i)] = true;
    }
`