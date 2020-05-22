while ((currentLine = line.readLine()) != null) {
    array = currentLine.toCharArray();
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i]);
    }
    System.out.println();
}