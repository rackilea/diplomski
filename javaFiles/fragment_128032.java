public static int[][] removeDuplicateRow(int[][] testArr)
    {
        /**
         * This method will remove the duplicate ROW from 2-D array and replace with {0,0,0}
         * However i assume array rows  =5 and coloums =3 ;) You can have the solution for that I assume
         */

        HashSet<String> hashSet = new HashSet<String>();
        int[][] result = new int[5][3];
        int i = 0;
        for(int[] a : testArr)
        {
            System.out.println(Arrays.toString(a));
            System.out.println(hashSet.contains(a));
            if(!hashSet.contains(Arrays.toString(a))){
                hashSet.add(Arrays.toString(a));
                result[i] = a;
            }
            i++;
        }

        System.out.println("old array : "+Arrays.deepToString(testArr));
        System.out.println("new array : "+Arrays.deepToString(result));

        return result;
    }