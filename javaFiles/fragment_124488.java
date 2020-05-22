for (int i=0; i < arr.length -1; i++) {
            if (arr[i] > arr[i+1]) {
            tempValue = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tempValue;

            performedSwap = true;
            }
        }