for (int i = 0; i < inputArray.length - 2; i++) {
            int currentmax = inputArray[i] * inputArray[i + 1];
            if (maxsofar < currentmax) {                
                maxsofar = currentmax;
            } //No need to handle the case where you say A=A :)
        }