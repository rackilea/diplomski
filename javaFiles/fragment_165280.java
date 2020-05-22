int i = 0;
do {
    int next = r.nextInt(49) + 1;
    boolean seen = false;
    for (int j = 0 ; j != i ; j++) {
        if (lottoNumbers[j] == next) {
            seen = true;
            break;
        }
    }
    if (!seen) {
        lottoNumbers[i++] = next;
        System.out.print(" " + next);
    }
} while (i != lottoNumbers.length);