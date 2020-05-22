for (int r = 0; r < array.size(); r++) {
        for (int h = 0; h < arr.size(); h++) {
            System.out.println(":array.get(" + r + ") * arr.get(" + h + "):");
            for (int i = 0; i < array.get(r).size(); i++) {
                for (int j = 0; j < arr.get(h).size(); j++) {
                    int n1 = array.get(r).get(i);
                    int n2 = arr.get(h).get(j);
                    System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
                }
            }
        }
    }