public class DieTester2{
    public static void main(String[] args) {
        // write your code here
        if(die1.getValue() == die2.getValue()){
            String message = getMessage(die1.getValue() + die2.getValue());
            // do whatever you need to do with message
        }
    }

    public static String getMessage(int sum) {
        String message;
        switch (sum){
            case 2:
                message = "Snake Eyes!";
                break;
            case 4:
                message = "Four, the hard way!";
                break;
            case 6:
                message = "Hard Six!";
                break;
            case 8:
                message = "Eight, the hard way!";
                break;
            case 10:
                message = "Hard Ten";
                break;
            case 12:
                message = "Box Cars!";
                break;
            default:
                message = "Something went wrong";
                break;
        }
        return message;
    }
}