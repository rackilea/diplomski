String[] values = {"2","4","6","8","10"};
    for(int i=0; i<emps.length; i++){
        emps[i] = new EMP();//Need to initialize object here!
        for(int j=0; j<values.length; j++){
            emps[i].setId(values[j]); 
            emps[i].setName(values[j]);
            emps[i].setDep(values[j]);
            emps[i].setSal(values[j]);
        }
    }