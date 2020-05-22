for (int i1 = array1.length/2+1, i2 = array2.length-1; 
            i1 >= 0  && i2 >=0 ; 
            i1--, i2--) {
        array2[i2] = array1[i1];
    } 
    System.out.println(Arrays.toString(array2));