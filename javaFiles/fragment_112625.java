List<MyCustomObject> list= new ArrayList<MyCustomObject>();

    int index = 0;
    for (Object profile : profiles) {

        // Safety check before casting the object
        if (profile instanceof MyCustomObject) {
            list.add((MyCustomObject) profile);    // wont crash now
        } else {
            // other type of object. Handle it separately
        }                   
     }