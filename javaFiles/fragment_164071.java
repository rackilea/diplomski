public static void mergesort(int[] input, int[] temp, 
                                 int start, int end, 
                                 boolean intoTemp) {
        if (start == end) {
            return; 
        }

        if ((start + 1) == end) {
            if (intoTemp == true) {
                temp[start] = input[start];
                return;
            }
        }

        if (intoTemp == false) {
            intoTemp = true;
            int mid = (start + end)/2;
            mergesort(input, temp, start, mid, intoTemp);
            mergesort(input, temp, mid, end, intoTemp);
            merge(temp, input, start, mid, end);
        } else {
            intoTemp = false;
            int mid = (start + end)/2;
            mergesort(input, temp, start, mid, intoTemp);
            mergesort(input, temp, mid, end, intoTemp);
            merge(input, temp, start, mid, end);
        }
    }

    public static void merge(int[] input, int[] output, 
                             int start, int mid, int end) {
        int i = start;
        int j = mid;                          // using j instead of k
                                              // and mid instead of j

        int index = start;

        while (i < mid && j < end) {          // using mid
            if (input[i] <= input[j]) {
                output[index] = input[i];
                i++;
                index++;
            } else {                          // change
                output[index] = input[j];     // was input[i]
                j++;
                index++;
            }
        }    

        while (i < mid) {                     // using mid
            output[index] = input[i];
            i++;                              // changed order for consistency
            index++;
        }

        while (j < end) {
            output[index] = input[j];
            j++;                              // changed order for consistency
            index++;
        }
    }