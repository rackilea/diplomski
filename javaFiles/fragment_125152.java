try {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = 1.0 / tab[i];

            if (tab[i] == Double.POSITIVE_INFINITY ||
                    tab[i] == Double.NEGATIVE_INFINITY)
                throw new ArithmeticException();
        }
    } catch (ArithmeticException ae) {
        System.out.println("ArithmeticException occured!");
    }