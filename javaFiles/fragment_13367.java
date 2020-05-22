public static char[] reverseOrder(char[] a, int index) {
        int step = 0;
        char[] newArr = new char[a.length];
        for (int j = 0; j < index; j++) {
            System.out.println(j);
            newArr[j] = a[j]; // adding elements to new arr till index=largestX
            System.out.println(newArr[j] = a[j]);
        }
        for (int i = index; i < a.length; i++) {
            System.out.println(i);
            newArr[index] = a[a.length - step - 1]; // adding remaining values
                                                    // but with reversing order
            System.out.println(newArr[index] = a[a.length - step - 1]);
            step++;index++;
        }
        for (char c : newArr)
            System.out.println(c);
        return newArr;
    }