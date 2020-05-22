for(String s1 : source){
    boolean found = false;
    for(String s2 : target){
        if(s1.length() > 4 && s2.length() > 4){
            String sKey = s1.substring(1,5);
            String tKey = s2.substring(1,5);
            if(sKey.equals(tKey)){
                found=true;
                break;
            }
        }
    }
    if(found){
        //found logic
    } else{
        //not found logic
    }
}