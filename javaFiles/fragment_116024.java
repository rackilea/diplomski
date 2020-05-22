for (int i = 0; i < str.length; i++) {
    for (int j = 1; j < str.length; j++) {
        if (i == j)
            continue;
        for (int k = 2; k < str.length; k++) {
            if (i == k || j == k)
                continue;
            System.out.println(str[i] + "_" + str[j] + "_" + str[k]);
        }
    }
}