public class LargeInteger {

    private int[] intArray;

    public LargeInteger(String s) {

        intArray = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            intArray[i] = Character.digit(s.charAt(i), 10);
        }
    }

    public void display() {

         for (int i = 0; i < intArray.length; i++) {     
                System.out.print(intArray[i]);
            }
    }   
}