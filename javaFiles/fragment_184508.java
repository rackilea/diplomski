private int[] readData() {
    File f = new File("data.txt");
    int count = 0;
    int[] newData = new int[100];
    try {
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            newData[count++] = s.nextInt(); // maybe you should handle the case where your input is too large for the array "newData"
        }
        return Arrays.copyOf(newData, count);
    } catch (Exception e) {
        System.out.println("Could not read the file.");
    }

    return null;
}