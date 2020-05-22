int distance = 0;
    for(int ii=0;ii<x.size();ii++) {
        for(int jj=0; jj<x.get(ii).coordinates.size();jj++) {
             //you keep assigning new values 
             distance = Math.abs(x.get(ii).coordinates.get(jj)) + Math.abs(x.get(ii).coordinates.get(jj));
        }   
        //and then you add
        result.add(distance);
    }