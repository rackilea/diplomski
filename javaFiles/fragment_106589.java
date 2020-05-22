private static void selectionSort(int[] digits) {

        for (int i = 0; i < digits.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[j] < digits[index]) {
                    index = j;
                }
               //previously u were doing swapping here
            //System.out.println("inner : " + convert(digits));
            }
            //i shifted the swapping block to this place
            int min = digits[index];
            digits[index] = digits[i];
            digits[i] = min; 

            //System.out.println("outer : " + convert(digits));
        }
        System.out.println("Array after sorrting:");
        System.out.println("Number of digits in array: " + digits.length);
        System.out.print("Digits in array: ");
        for (int i: digits) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }