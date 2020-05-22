if(x == 1){
        testAndA(this::f1, x + 1, y);
        testAndA(this::f1, x, y + 1);
    } else {
        testAndA(this::f2, x + 1, y);
        testAndA(this::f2, x, y + 1);
    }