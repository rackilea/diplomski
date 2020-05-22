for (int x = 0; x < (ar.length); x++) {
    if (ar[x] == z) {
        continue; // If it is equal to z go back to the loop again
    }

    ar2[zero++] = ar[x];
}

for (int i = 0; i < ar2.length; i++) {
    System.out.println(ar2[i]);
}