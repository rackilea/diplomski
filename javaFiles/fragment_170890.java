public int[] readLine(Scanner fileReader) {
    int[] array = new int[fileReader.nextInt()];
    for (int i = 0; i < array.length; i++){
        array[i] = fileReader.nextInt();
    }

    return array;

}