//    going line by line for explanation

    public static Integer[] sort(Integer[] array)
    {
        Arrays.sort(array);//first of all sort the numbers in increasing order
        final double median;
        /*
        now in sorted numbers median is the
        --- average of middle two values for even count of numbers; like for 10 numbers median is (4th item +5th item )/2
        --- middle value if there are odd count of numbers like for 11 items the median is the 6th item
         */
        if (array.length % 2 == 0)
            median = ((double)array[array.length/2-1]+ (double)array[array.length/2])/2;
        else
            median =  array [array.length/2];
        //now we have the median



//        here we have a Comparator for comparing any value during with the median value
        Comparator<Integer> compareToMedian= new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
//                first we check the distance of two numbers from the median; that is the difference from the median
                double value = Math.abs(o1 - median) - Math.abs(o2 - median);
                if (value == 0)//if the difference is same then we compare the numbers
                    value = o1 - o2;
                return (int)value;//otherwise we return the difference
            }
        };

        Arrays.sort(array, compareToMedian);//sort the numbers with respect to median
        return array;
    }