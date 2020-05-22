CustomInteger[] vec = new CustomInteger[]{new CustomInteger(5), new CustomInteger(1), new CustomInteger(2), new CustomInteger(4), new CustomInteger(5), new CustomInteger(2)};

    for (int i = 0; i < vec.length - 1; i++) {
        int min = i;
        for (int j = i + 1; j < vec.length; j++) {
            if (vec[j].getValue() < vec[min].getValue()) {
                min = j;
            }
        }
        if (min != i) {
            goodSwap(vec[i], vec[min]);
        }
    }

    for (int i = 0; i < vec.length; i++) {
        System.out.print(vec[i].getValue() + " ");
    }