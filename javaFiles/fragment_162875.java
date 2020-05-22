public void foo (final int x, final int y){
    try{
        final int z = x+y;
    }
    catch (final Exception z){
        final String message = "";
        throw new RuntimeException(message);
    }
}