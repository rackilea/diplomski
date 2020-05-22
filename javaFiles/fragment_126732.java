int i = 0;
int j = 0;
int k = 0;
int c[] = new int[9];
while (i < m && j < n) {

    if (A[i] < B[j]) {

        c[k++] = A[i++];

    } else {
        c[k++] = B[j++];
    }

}


for (; i < m; i++) {
    c[k++] = A[i];
}

for (; j <= n; j++) {
    c[k++] = B[j];
}


return c;