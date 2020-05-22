public static void insertionSort(ArrayList<Double> list) {
        double temp;
        int previousIndex;

        for (int index = 1; index < list.size(); index++) {
            temp = list.get(index);
            previousIndex = index - 1;
            while (previousIndex >= 0 && (list.get(previousIndex) > temp)) {
                list.set((previousIndex + 1), list.get(previousIndex));
                previousIndex -= 1;
            }
            if (previousIndex >= 0 && list.get(previousIndex) > temp) {
                list.set((previousIndex + 1), list.get(previousIndex));
                list.set((previousIndex + 1), temp);
            } else {
                list.set((previousIndex + 1), temp);
            }
        }
    }