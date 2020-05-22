if(from.equals("BGN") && to.equals("USD")) {
       for(currency = 0; currency <= amount; currency++) {
           System.out.printf("%.2f leva = %.2f $\n",currency,(currency/1.52)); }
    }
    else if(from.equals("USD") && to.equals("BGN")) {
        for(currency = 0; currency <= amount; currency++) {
            System.out.printf("%.2f $ = %.2f leva\n",currency,(currency/1.52)); }
    }
    else {
    //unsupported
    }