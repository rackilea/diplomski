for (int i = 0; i < ar.size() - 1; i++) {
    for (int j = i; j < ar.size(); j++) {
        if (ar.get(j) < ar.get(i)) {
            Integer temp = ar.get(j);
            ar.set(j, ar.get(i));
            ar.set(i, temp);       
        }
    }
}