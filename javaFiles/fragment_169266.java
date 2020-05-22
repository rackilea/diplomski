for (int i = 20; i < Integer.MAX_VALUE; i++) {
      int seImparte = 0;
        for (int j = 7; j <= 20; j++) {
            if (i % j != 0) {
                seImparte++; break;
            }
        }
        if (seImparte == 0) {
            System.out.println(i);
            break;
        }
    }