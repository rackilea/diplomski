static void doQuickSort(double[] daFinishTime, int i, int j) {
        double dTemp;
        String sTemp;

        int start = i;
        int end = j;
        // Pivot
        double dPivot = daFinishTime[(i + j) / 2];

        // Partition
        while (start <= end) {
            while (daFinishTime[start] < dPivot) {
                start++;
            }
            while (daFinishTime[end] > dPivot) {
                end--;
            }
            if (start <= end) {
                dTemp = daFinishTime[start];
                daFinishTime[start] = daFinishTime[end];
                daFinishTime[end] = dTemp;

                sTemp = saRunnerName[start];
                saRunnerName[start] = saRunnerName[end];
                saRunnerName[end] = sTemp;

                start++;
                end--;
            }
        }

        // Recursion
        if (start < j) {
            doQuickSort(daFinishTime, start, j);
        }
        if (i < end) {
            doQuickSort(daFinishTime, i, end);
        }
    }