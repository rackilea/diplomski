String num = "73167";
        int biggestProduct = 1;
        int currProduct = 1;
        char[] array = num.toCharArray();

        for (int x = 0; x < array.length; x++) {
            if (x < 5) {
                System.out.println(currProduct + " * " + array[x] + " = " + currProduct * Character.getNumericValue(array[x]));
                currProduct *= Character.getNumericValue(array[x]);
            }

        }