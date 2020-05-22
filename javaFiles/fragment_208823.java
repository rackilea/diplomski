// Create a temp Array to keep the data for the loop
int[] temp = new int[a1.length];

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
        temp[position] = a1[i];
        position++;
    }
}

// This part merely copies the temp array of the previous size into the proper sized smaller array
int[] result = new int[position];

for (int k = 0; k < result.length; k++) {
    result[k] = temp[k];
}