public static void main(String[] args) {
        String[] names = { "hi", "you", "there" };

        printArray(names);
    }

    public static <T> void printArray(T[] array) {
        for (int i = array.length - 1; i >= 0; i--)
            System.out.print(array[i] + " ");

    }