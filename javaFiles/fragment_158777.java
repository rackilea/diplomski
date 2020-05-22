int unique = 0;
int i, j, k;
int x[] = {1, 2, 3, 4, 5};
int y[] = {1, 3, 5, 7, 9};

for (i = 0; i < x.length; i++) {
    for (j = 0; j < y.length; j++) {
        if (x[i] == y[j]) {
            unique = 1;
        }
    }
    if (unique == 0) {
        System.out.print(x[i]);
        unique = 0;
    }
    unique = 0;
}