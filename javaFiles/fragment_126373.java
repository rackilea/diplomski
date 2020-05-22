for(int temp =0; temp < 1000 ; temp++){
        if(temp % 3 == 0){
            x.add(temp);
            totalforthree += temp;
        }else if(temp % 5 == 0){
            y.add(temp);
            totalforfive += temp;
        }
    }