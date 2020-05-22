if (array1[indexArray1] < array2[indexArray2]) {        // if element in array1 is smaller than in array2
            array3[indexArray3] = array1[indexArray1];      
            System.out.print(array3[indexArray3] + " ");
            indexArray1++;
            indexArray3++;

        }
        else if (array1[indexArray1] > array2[indexArray2]) {        // if element in array1 is bigger than in array2
            array3[indexArray3] = array2[indexArray2];
            System.out.print(array3[indexArray3] + " ");
            indexArray2++;
            indexArray3++;
        }