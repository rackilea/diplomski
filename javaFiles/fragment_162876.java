public void foo (int x, int y){
    try{
        int z = x+y;
    }
    catch ( Exception z){
        String message = "";
        throw new RuntimeException(message);
    }
}