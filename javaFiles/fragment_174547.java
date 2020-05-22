public static boolean isWMAPresent(){
    try {
        Class.forName(
               "javax.wireless.messaging.MessageConnection" );
        return true;
    }
    catch( Exception e ){
        return false;
    }
}