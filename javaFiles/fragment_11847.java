Resources res=getResources();
TypedArray index=res.obtainTypedArray(R.array.arrind); //call the index array

    for (int i = 0; i < n; i++) {
        int id=index.getResourceId(i,0); //get the index
        if (id != 0){
            String[] handle=new String[n];
            handle=res.getStringArray(id); //use the index to get the actual array
            String a=handle[0]; //Access items in your XML array
            String b=handle[1];
            c=...

        }
    }