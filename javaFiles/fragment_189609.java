public static int[] gradeDistn (char[] grades){
        int[] counts = new int[6];
        for (int i = 0; i < grades.length; i++) //count the occurrences
            counts[grades[i] - 'A']++;
        return counts;

    }