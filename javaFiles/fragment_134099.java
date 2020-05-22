public static int g(LinkedList<Integer> list) {
    int t = 0;

    for (int i = 0; i < list.size(); i++) {           // O(n) - loop
        int tgt = list.get(i);                        // O(n)

        for (int j = i + 1; j < list.size(); j++) {   // O(n) - loop
            if (list.get(j) == tgt)                   // O(n)
                t += list.get(j);                     // O(n)
        }
    }

    return t;
}