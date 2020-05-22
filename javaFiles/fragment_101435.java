public class BubbleSortExample {

        public static void main(String[] args)
        {
            int[] array = { 7, 3, 11, 4, 20, 12, 98, 78, 45, 36 };
            String output = "Array items in original order\n";
            output += arrElements(array);
            bubbleSort(array);
            output += "\n\nData items in ascending order\n";
            output += arrElements(array);
            System.out.println(output);
        }

        public static void bubbleSort(int arr[]) {
            for (char i = 1; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }

        public static void swap(int[] arr, int first, int end) {
            int temp;
            temp = arr[first];
            arr[first] = arr[end];
            arr[end] = temp;
        }

        public static String arrElements(int arr[]) {
            String elements = " ";
            for (int i = 0; i < arr.length; i++) {
                elements += " " + arr[i];
            }
            return elements;
        }
    }