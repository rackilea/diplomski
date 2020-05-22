public boolean Exists(String user){
    Cursor res = getAllData();
    int flag=0;
    while (res.moveToNext()){
        String email =res.getString(3);
        if(email.equals(user)){
            flag++;
        }
    }

    if(flag==0){
        return false;
    }
    else {
        return true;
    }
}