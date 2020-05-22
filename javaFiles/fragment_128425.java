for (n1 = 1; n1 < n; n1++) {
    for (n2 = 1; n2 < n; n2++) {
        int max = Math.max(n1, n2) + 1;
        for (n3 = max; n3 <= n; n3++) {
            for (char c1 = 0; c1 < l; c1++) {
                char nc1 = (char)(c1 + 'a');
                for (char c2 = 0; c2 < l; c2++) {
                    char nc2 = (char)(c2 + 'a');

                    System.out.println("" + n1 + n2 + nc1 + nc2 + n3);
                }
            }
        }
    }
}