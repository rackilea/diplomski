public boolean add(IQuestion q){
    try{
        test.add(q);
        return true;
    }catch(Exception e){
        return false;
    }
}