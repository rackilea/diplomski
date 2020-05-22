public static int parse(String str, int number){
    while(true){
        try{
            // Attempt to parse it as an int
            return Integer.parseInt(str);
        catch(Exception e){
            // Request the input again
            System.out.println("Integer #" + number + " was entered incorrectly, please enter it again: ");
            str = scan.next();
        }
    }
    return 0; // Stop compiler from complaining about no return statement
}