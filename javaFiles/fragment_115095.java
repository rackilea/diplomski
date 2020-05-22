public class Test{

            static int sum(final int s)
            {
                final String numbers = String.valueOf(s);
                final int amountOfDigits = numbers.length();
                int sum = Character.getNumericValue(numbers.charAt(0));
                for(int i = 1; i < amountOfDigits; i++) {
                    sum += Character.getNumericValue(numbers.charAt(i));
                }

                if(sum > 9) {
                    return sum(sum);    
                } else {
                    return sum;
                }
            }

            public static void main(String[] args) 
            {
             int result = Test.sum(678);
             System.out.println(result);



            }
}