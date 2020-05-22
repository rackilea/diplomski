class SearchArray {
    private final int[] array = new int[10];
    private final Random random = new Random();

    public SearchArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        Arrays.sort(array);
    }

    public String toString() {
        return Arrays.toString(array);
    }

    public boolean contains(int value) {
        int low = 0;
        int high = array.length - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (array[middle] == value) {
                return true;
            }
            if (array[middle] < value) {
                low = middle + 1;
            }
            if (array[middle] > value) {
                high = middle - 1;
            }
        }
        return false;
    }          

class lab4point2 {
    public static void main(String args[]) {
        SearchArray array = new SearchArray();
        System.out.println(array.toString());

        System.out.print("Enter a value to see if it is present. ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextint();
        if (array.contains(value)) {
            System.out.print("Value is present. ");
        } else {
            System.out.print("Value is not present. ");
        }
    }
}