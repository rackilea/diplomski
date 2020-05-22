for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            for(int m = 0; m < i * 2; m++) {
                if(m == j && m == i) {
                    System.out.println("i: " + i);
                    System.out.println("j: " + j);
                    System.out.println("m: " + m);
                }
            }
        }
    }