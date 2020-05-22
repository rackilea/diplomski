ArrayList<Integer> changeA = new ArrayList<Integer>() {{
        add(5);
        add(10);
        add(20);
        add(50);
        add(100);
    }};

    int change = 10;
    outer: for (int i = changeA.size() - 1; i >= 0 ; i--) {
        for (int j = 1; j <= 10; j++) {
            int fullChange = changeA.get(i) * j;
            System.out.println("changeA: " + changeA.get(i) + ".");
            System.out.println("fullChange: " + fullChange);
            if (fullChange==change) {
                System.out.println("El cambio es: "+fullChange+" en monedas de: "+
                        changeA.get(i)+" con un total de: "+j+" monedas");
                break outer;
            }

        }
    }