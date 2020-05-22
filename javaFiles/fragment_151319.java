public static boolean isValidElement(String token) {
    try{
        int foo = Integer.parseInt(token);
        if(foo >= 0 && foo <= 255)
            return true;
        else 
            return false;
    } catch (NumberFormatException ex) {
        return false;
    }
}