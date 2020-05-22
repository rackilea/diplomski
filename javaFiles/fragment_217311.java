int[][] raggedArray = new int[5][];
      raggedArray[0] = new int[]{1,2,3};
      raggedArray[1] = new int[]{4,5,6,7,8,9};
      raggedArray[2] = new int[]{10,12,13,14};
      raggedArray[3] = new int[]{15};
      raggedArray[4] = new int[]{16,17,18,19,20};
      for (int[] array : raggedArray) {
         System.out.println(Arrays.toString(array));
      }