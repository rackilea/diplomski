int[] array = new int[9];
    array[0] = 0;
    array[1] = 1;
    array[2] = 2;
    array[3] = 3;
    array[4] = 4;

    int num = 3;


    for(int i = 0; i < array.length; i++){

        if(num==array[i]){
            System.out.println("found at index: " + i);
        }