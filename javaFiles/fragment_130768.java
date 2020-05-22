int k; // init k before the cycle
    for (k = 0; k < listSize; k++) {

        Words w = newList.get(k);

        System.out.println("Word : " + ++j + " " + w.getWord() + " "
                + w.getCount());

        // System.out.println(w.getWord());

    }

    if (k > 0) {
        int lastCount = newList.get(k - 1).getCount(); // last printed count
        // print words from the k-th
        while (k < newList.size()
               && newList.get(k).getCount() == lastCount) {
            Words w = newList.get(k);

            System.out.println("Word : " + ++j + " " + w.getWord() + " "
                    + w.getCount());

            ++k;
        }
    }