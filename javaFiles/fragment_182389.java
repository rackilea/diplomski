public class IsEven {
            public static void main(String[] args) {

                // initializer list specifies the value for each element
                int[] nums = { 8, 16, 9, 52, 3, 15, 27, 6, 14, 25, 2, 10 };

                System.out.printf("%11s%11s\n", "Number", "Even"); // column heading

                // output each array element's value
                for (int counter = 0; counter < nums.length; counter++) {
                    if (isEven(nums[counter])) {
                        // System.out.printf("Even numbers are =  %d\n", nums[counter]);
                        System.out.printf("%11d%11s\n", nums[counter], "Yes"); // column heading
                    }else{
                        System.out.printf("%11d%11s\n", nums[counter], "No"); // column heading
                    }
                }
            } // end method main

            // return true if Array is Even
            public static boolean isEven(int even) {
                return even % 2 == 0;
            } // end method boolean
        } // end class IsEven