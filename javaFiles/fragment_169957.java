while (pass <= n) {                     // executes n times
        for (int index = 0; index < n; index++) {      // executes n times
            for (int count = 1; count < 10; count++) { // always executes 9 times.. irrespective of "n". So. it doesn't matter.
                if (arr1[pass] == arr2[index]) {
                    arr1[pass]++;
                }
            }
        }