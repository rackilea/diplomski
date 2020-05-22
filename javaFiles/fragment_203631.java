public int[] last5() {
        LinkedList<Integer> list = new LinkedList<>();
        int[] toReturn = new int[5];
        int quantity = 0;
        int last;

        last = read();
        while (last != -1) {
            list.add(last);

            if (quantity >= 5)
                list.pop();
            else
                quantity++;
            last = read();
        }

        for (int i = 0; i < quantity; i++) {
            toReturn[i] = list.get(i);
        }
        return toReturn;
    }
}