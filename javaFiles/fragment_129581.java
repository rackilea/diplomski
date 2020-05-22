public static void product(int[] items, int subGroup) {
    if (subGroup > 0 && items.length >= subGroup) {
        // this save the largest numbers:
        PriorityQueue<Integer> maxElements = new PriorityQueue<>(subGroup);
        int product = 1;
        for (int i = 0; i < items.length; i++) {
            // the queue of largest numbers is full:
            if (maxElements.size() == subGroup) {
                // the minimum of previous largest number is lower than the new number
                if (maxElements.peek() < items[i]) {
                    // swapping
                    product /= maxElements.poll();
                    product *= items[i];
                    maxElements.add(items[i]);
                }
                System.out.println(product);
            } else {
                product *= items[i];
                maxElements.add(items[i]);
                if (maxElements.size() < subGroup) {
                    //the queue of largest numbers isn't full
                    System.out.println("-1");
                } else {
                    // the queue of largest numbers is full now
                    System.out.println(product);
                }
            }
        }
    }
}

public static void main(String[] args) {
    int[] input = {6, 2, 9, 3, 8};
    product(input, 3);
}