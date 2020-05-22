while(x.get(i) != target){
        x.add(j + x.get(i));
        i++;
        j = x.get(i-1);

        if(x.get(i) > target){
            x.clear();
            x.add(0);
            i=0;
            j=k; // this is the key
            k++;
        }
    };