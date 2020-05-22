String[][] sorted = new String[2][3]; //hold sorted data

    String[] unsorted = new String[2]; //hold unsorted data

    unsorted[0] = one;
    unsorted[1] = two;

    int[] year = new int[2];
    int[] month = new int[2];
    int[] day = new int[2];

    for (int i = 0; i < 2; i++){            
        sorted[i] = unsorted[i].split("-"); //sort data         
    }

    //place sorted data into seperate arrays to make calculations more logical to look at
    for (int i = 0; i < 2; i++){
        year[i] = Integer.parseInt(sorted[i][1]);
        month[i] = Integer.parseInt(sorted[i][2]);
        day[i] = Integer.parseInt(sorted[i][3]);        
    }