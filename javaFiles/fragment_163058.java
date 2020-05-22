public class Missing {
    public static void main(String[] args) {

        int ar [] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        int sum = 0; 
        for(int num: ar)
        {
            sum = sum+num;
        }

        int n = ar.length;
        int a = ar[0];
        int l =ar[ar.length - 1];
        int total = (n * (a + l)) / 2;
        System.out.print("The missing number is "+(sum - total));
        // outputs 0 which is correct nothing is missing

        // Now if you remove say 12 from the array
        // by changing the array to int ar [] = {1,2,3,4,5,6,7,8,9,10,11,0,13};
        // you should get back -12 which means 12 is missing
    }
}