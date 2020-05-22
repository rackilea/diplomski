public T get(){
    try{
        return mClass.getDeclaredConstructor( Integer.TYPE ).newInstance( 10 );
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}