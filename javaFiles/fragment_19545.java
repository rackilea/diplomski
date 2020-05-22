futures.forEach(future->{
    try{
        future.get();
    }catch(Exception e){
        //two types of exceptions they both should be handled appropriately.
    }
});