public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            int[] array1 = new int[input.nextInt()];
            int maxIndex = -1;
            int minIndex = -1;


            for (int i = 0; i < array1.length; i++) {
                array1[i] = input.nextInt();
            }
            int max = array1[0];
            int least = array1[0];
            for (int i = 0; i < array1.length; i++) {
                if (max < array1[i]) {
                    max = array1[i];
                    maxIndex = i;
                } else if (least > array1[i]) {
                    least = array1[i];
                    minIndex = i;
                }
            }

            int temp = array1[0];
            array1[0] = max;
            array1[maxIndex] = temp;

            temp = array1[array1.length - 1];
            array1[array1.length - 1] = least;
            array1[minIndex] = temp;

            for(int a: array1){
                System.out.println(a);
            }
            input.close();
        }
    }