String [] firstSplit = thisLine.split(" ");
int [][] numbers = new int [firstSplit.length][];
for (int i = 0; i < firstSplit.length; i++) {
    firstSplit[i] = firstSplit[i].replace("[", "").replace("]", "");
    String[] secondSplit = firstSplit[i].split(",");
    numbers[i] = new int[secondSplit.length];

    for (int j = 0; j < secondSplit.length; j++) {
        int value = Integer.parseInt(secondSplit[j]);
        numbers[i][j] = value;
        System.out.println(value);
    }
}