int n = 3;

    int result = 0;
    for(int i = 0; i <= n; ++i) {
        if(i % 2 == 0) {
            result += i;
        }
    }
    System.out.println(result);