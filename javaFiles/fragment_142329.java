public class Main {

    public static void main(String[] args) {

        char[] keyArray =  {'a', 'b', 'c', 'd',  'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] valueArray = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'p', 'q', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd',  'c', 'b', 'a'};

        String myString = "abcxyz";
        char[] myStringArray = myString.toCharArray();

        for(int x = 0; x<myString.length(); x++)
        {
            for(int i = 0; i<keyArray.length; i++)
            {
                if(myStringArray[x] == keyArray[i])
                {
                    //System.out.println(valueArray[i]); would give the output "zyxcba" as expected 
                    myStringArray[x] = valueArray[i]; // this will only change the characters in the first half of keyArray 
                    break; //Exit the loop checking against the keyArray
                }
            }
        }

        System.out.println(myStringArray); //Outputs "abccba" instead of "zyxcba"
    }
}