for (int i = 1; i < (1<<n); i++) {
    if ((i & (i - 1)) == 0) {
        continue;
    }

    System.out.print("{ ");

    for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
            System.out.print(set[j] + " ");
        }
    }

    System.out.println("}");
}