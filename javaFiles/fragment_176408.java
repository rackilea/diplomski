public void printDice(int[] array1, ImageView[] array2) {
    for (int i = 0; i < array1.length; i++) {
        array2[i].setImageResource(diceImages[array1[i] - 1]);
        array2[i].setVisibility(View.VISIBLE);
        array2[i].setTag(array1[i]);
    }
}