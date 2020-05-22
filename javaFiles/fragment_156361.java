public class programPalindrome 

{ 

    static public boolean isPalindromic(long value){
        String valueAsString = Long.toString(value);
        String reverseString = (new StringBuffer(valueAsString)).reverse().toString();
        if(valueAsString.equals(reverseString)){
            return true;
        }
        else{
            return false;
        }
    }


    public static void main(String[] args) 
    {

        System.out.println(args[0] + " is palindromic == " 
                + isPalindromic(Long.parseLong(args[0])));
    } 
}