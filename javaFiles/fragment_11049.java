int[] starNegOne = {-1, -1, -1};
for (int i = 0; i < 10; i++) {
    if (i < 5) {
        int[] star = {i, 2*i, 3*i};
        starArray.add(star);
    } else {
        starArray.add(starNegOne);
    }
}