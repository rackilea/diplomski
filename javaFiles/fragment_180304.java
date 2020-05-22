for (n = 21; n > 0; n++) {
        bool divisibleByAll = true;

        for (int m = 1; m <= 20; m++) {
            s = n % m;

            if(s != 0) {
                divisibleByAll = false;
                break; //don't bother checking the rest
            }
        }

        if (divisibleByAll) {
            System.out.println(n);
            break;
        }

    }