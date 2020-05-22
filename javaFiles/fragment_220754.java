// Count The Repeated Numbers
    for(int i=0; i<size; ){   //<--- note the removal of i++

        int key = Array[i];
        int counter = 0;

        for(int j=i; j<size; j++){
            if(key == Array[j]){
                counter++;
            }else{
                i=j;
                break;
            }
        }

        if(counter > 1 ){
            System.out.println(key+":"+counter+" times ");
        }
    }