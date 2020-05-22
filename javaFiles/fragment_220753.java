// Count The Repeated Numbers
    for(int i=0; i<size; i++){

        int key = Array[i];
        int counter = 0;

        for(int j=i; j<size; j++){
            if(key == Array[j]){
                counter++;
            }
        }

        if(counter > 1 ){
            System.out.println(Array[i]+":"+counter+" times ");
        }
    }