low = numArray[0];
            for (int countB = 0; countB < numArray.length-1; countB++) {
                int newlow = numArray[countB];
                if (newlow < low) {
                    low = newlow;
                }
            }