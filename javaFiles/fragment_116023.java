String[] str = {"a","b","c","d"};

for (int i = 0; i < str.length; i++) {
    for (int j = 1; j < str.length; j++) {
        if (str[j].equals(str[i]))
            continue;
        for (int k = 2; k < str.length; k++) {
            if (str[k].equals(str[i]) || str[k].equals(str[j]))
                continue;
            System.out.println(str[i] + "_" + str[j] + "_" + str[k]);
        }
    }
}