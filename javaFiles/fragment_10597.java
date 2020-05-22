public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(System.in);
            int[] inputNumbers, ocurrences;
            int index = 0, size;

            System.out.println("How many numbers to enter? (At most 50)");
            size = input.nextInt();
            inputNumbers = new int[size];
            ocurrences = new int[size];

            System.out.println("Enter each of the numbers. Please put a space between each number.");

            for (int i = 0; i < size; i++) {
                int nextNumber = input.nextInt();
                if (!isInArray(inputNumbers, nextNumber)) {
                    inputNumbers[index] = nextNumber;
                    ocurrences[index] = 1;
                    index++;
                } else {
                    int oIndex = search(inputNumbers, nextNumber);
                    ocurrences[oIndex] ++;
                }
            }

            sort(inputNumbers, ocurrences);
            System.out.println("N\t\tCount");
            for (int i = 0; i < index; i++) {
                System.out.println(inputNumbers[i] + "\t\t" + ocurrences[i]);
            }
        } finally {
            input.close();
        }
    }

    public static void sort(int[] inputNumbers, int[] ocurrences) {
        int size = inputNumbers.length;
        for (int current = 0; current < size; current++) {
            int max = current;
            for (int i = current; i < size; i++) {
                if (inputNumbers[i] > inputNumbers[max])
                    max = i;
            }
            int temp = inputNumbers[max];
            inputNumbers[max] = inputNumbers[current];
            inputNumbers[current] = temp;

            temp = ocurrences[max];
            ocurrences[max] = ocurrences[current];
            ocurrences[current] = temp;
        }
    }

    public static int search(int[] array, int number) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (array[i] == number)
                return i;
        }
        return -1;
    }

    public static boolean isInArray(int[] array, int number) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (array[i] == number)
                return true;
        }
        return false;
    }