for (int item : test){
    if (!ht.containsKey(item)){
        check = true;
    } else{
        check = false;
        ht.put(item, check);
    }
    }