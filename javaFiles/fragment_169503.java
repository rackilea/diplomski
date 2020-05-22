for (int i = 1 ; i < n.length ; i++)
    if (n[i] == 0 && n[i - 1] != 0) {
        int tmp = n[i - 1];
        n[i - 1] = n[i];
        n[i] = tmp;
    }