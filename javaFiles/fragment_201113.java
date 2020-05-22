public int compare(String a, String b) {
        Double va = base.get(a);
        Double vb = base.get(b);
        if(va > vb) {
            return -1;
        } else if(va < vb) {
            return 1;
        } else {
            return a.compareTo(b);
        }
    }