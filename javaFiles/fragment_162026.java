public static void main(String[] args) {
    try{
        StringBuilder persianHello = new StringBuilder("سلام");
        PrintStream outStream = new PrintStream(System.out, true, "UTF-8");
        outStream.println("Hello world!");
        outStream.println(persianHello); // Renders backwards in console, but correctly in the IDE.
        byte directionality = Character.getDirectionality(persianHello.charAt(0));
        if (directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC) {
            outStream.println("Reversed string:" + persianHello.reverse()); // Renders correctly in console, but backwards in the IDE...
        }
    } catch(UnsupportedEncodingException e){
        System.out.println("Caught exception: " + e.getMessage());
    }
}