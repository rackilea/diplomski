int[] array = {1,2,2,3,3,3,2,2,1};
    int k = 2;
    // get first element
    int element=array[0];

    // set tot to 1 
    int tot=1;
        for (int i = 1; i < array.length; i++) {
            // if values are same , increment tot
            if (element==array[i]) {
                tot++;
            }else {
                // set element to new found value and tot = 1
                element=array[i];
                tot=1;
            }
            // when any elements exceeds the k limit 
            // print element and stop the loop
            if (tot>k) {
                System.out.println(array[i]);
                break;
            }
        }
        // to print -1 if tot > k never reached
        if (!(tot>k)) {
            System.out.println(-1);
        }