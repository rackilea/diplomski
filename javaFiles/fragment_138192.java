int k = 109;

    do {
        for(int i = 3; i < 9; i = i * 2) {
            if(k % i ==3) {
                k = k / 3;
            } else {
                k = k / 2;
            }
        }
        System.out.println(k);
    } while(k > 0);