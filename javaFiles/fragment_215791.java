for (int i =0; i<=  array.length  - 2;i++) {
      if (array[i][j] > array[i+1][j]) {
          //test whether the two elements are in the wrong order
          int temp = array[i][1];  //1 since CandidateScore is the second one
          array[i][1] = array[i+1][1];
          array[i+1][1]=temp;

          temp = array[i][0]; //interchange the CandidateIds
          array[i][0] = array[i+1][0];
          array[i+1][0]=temp;
          swapped = true;
        }
      }