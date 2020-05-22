for (int j = 0; j < copy.length; j++) {

    if (i != j && copy[i] == copy[j]) {
        counter++;
        array[j] = null;
    }

}

if (array[i] != null) {
    System.out.println("\t" + copy[i] + "\t"
            + convertToStars(counter));
}