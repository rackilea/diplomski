public void test(String str){

    if(str==null){
        throw new NullPointerException(); // now here you explicitly throws the error whenever you getting str object as null
    }

}