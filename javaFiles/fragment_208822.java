//populate the new array with the unique values
int position = 0;
for (int i = 0; i < a1.length; i++) {
    boolean unique = true;

    for (int j = 0; j < a2.length; j++) {
        if (a1[i] == a2[j]) {
            unique = false;
            break;
        }
    }

    if (unique == true) {
        result[position] = a1[i];
        position++;
    }
}