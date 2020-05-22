public static void main(String[] args) {
        int list[] = { 1, 2, 3, 4, 5 };
        int start = (int) (Math.ceil(list.length / 2));

        int list1[] = new int[list.length  - start];
        String output = "";

        for (int i = start; i < list.length; i++) {
            int indexB = (i - start);
            list1[indexB] = list[i]; // The error is concerned about this line
                                        // of code
        }
        for (int j = 0; j < list1.length; j++) {
            output += list1[j] + " ";
        }
        System.out.print(output);

    }