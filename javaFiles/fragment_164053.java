public void manip() {

    System.out.println("ArratList (Before) :" + Array);
    int sz = Array.size();
    for (int i = 0; i < sz - 1; i++) {
        Object o = Array.get(i);
        if (o instanceof Double) {
            if (Array.get(i).equals(x) & Array.get(i + 1).equals(y)) {
                if (i == 1) {

                    Array.add(0, item);
                } else {

                    Array.add(i - 1, item);
                }
                i = i + 3;
            } else {
                Array.remove(i - 1);
                Array.remove(i - 1);
                Array.remove(i - 1);
                i = i - 1;
            }
            sz = Array.size();
        }
    }

    System.out.println("ArratList (After) :" + Array);
 }