int[] array={12,23,-22,043,545,-4,-55,43,12,0,-99,-87};
   List<Integer> postiveNumbers=new ArrayList<Integer>();
    List<Integer> negativeNumbers=new ArrayList<Integer>();
    List<Integer> duplicateNumbers=new ArrayList<Integer>();
    for(int i=0;i<array.length;i++){
        if(!(postiveNumbers.contains(array[i])||negativeNumbers.contains(array[i]))) {//checks whether it contains duplicates

            if (array[i] >= 0) {
                postiveNumbers.add(array[i]);
            } else if (array[i] < 0) {
                negativeNumbers.add(array[i]);
            }
        }
        else duplicateNumbers.add(array[i]);
    }

    System.out.println(postiveNumbers);
    System.out.println(negativeNumbers);
    System.out.println(duplicateNumbers);