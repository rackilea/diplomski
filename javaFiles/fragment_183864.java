private static int[] computeModes(int[] array)
{
    int[] counts = new int[array.length];
    for (int i = 0; i < array.length; i++) {
        counts[array[i]]++;
    }
    int max = counts[0];
    for (int counter = 1; counter < counts.length; counter++) {
        if (counts[counter] > max) {
            max = counts[counter];
        }
    }

    int[] modes = new int[array.length];

    int j = 0;
    for (int i = 0; i < counts.length; i++) {
        if (counts[i] == max)
            modes[j++] = array[i];
    }

    return modes;
}