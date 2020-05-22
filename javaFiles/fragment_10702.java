public class FiveSeconds {
    private static Scanner scanner = new Scanner(System.in);
    private static long lastTime = 0;

    public static void main(String[] args) {    
        String input = scanner.nextLine();

        while(!input.equalsIgnoreCase("quit")){
            if(isValidAction()){
                System.out.println(input);
                lastTime = System.currentTimeMillis();
            } else {
                System.out.println("You are not allowed to do this yet");
            }

            input = scanner.nextLine();
        }       
    }

    private static boolean isValidAction(){
        return(System.currentTimeMillis() > (lastTime + 5000));
    }
}