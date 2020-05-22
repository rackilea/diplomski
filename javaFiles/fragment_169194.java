public double[][] quicksort(double[][] array, int key, int down, int top) {
    //create copy of array (the author wanted to return a new one)
    double[][] a = new double[array.length][2];
    System.arraycopy(array,   0, a, 0, a.length);

    int i = down; //lower limit
    int j = top;  //upper limit
    double x = a[(down + top) / 2][key]; //the pivot

    do {
      while (a[i][key] < x) { //skip over smaller elements in beginning
        i++;
      }
      while (a[j][key] > x) { //skip over larger elements in end
        j--;
      }

      //now do some partitioning
      if (i <= j) {
        //create temporary array, for swapping elements
        double[] temp = new double[a[i].length];

        for (int y = 0; y < a[i].length; y++) {
          temp[y] = a[i][y];
          a[i][y] = a[j][y];
          a[j][y] = temp[y];
        }
        i++;
        j--;
      }
    } while (i <= j);

    //if there is a non-empty lower partition, sort that
    if (down < j) {
      a = quicksort(a, key, down, j);
    }

    //if there is a non-empty upper partition, sort that
    if (i < top) {
      a = quicksort(a, key, i, top);
    }

    //return the result
    return a;
  }
}