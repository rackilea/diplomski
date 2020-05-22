public static void main(String[] args) {
    char array[] = new char[10];

    int emptyCounter = 0;
    for(int i = 0; i < array.length; i++) {
        if (array[i] == 0) {
            emptyCounter++;
        }
    }

    System.out.println(emptyCounter);
}