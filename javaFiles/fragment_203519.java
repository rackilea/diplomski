class Solution {
    public boolean isHappy(int n) {
        if (n == 0) return false;

        int digit, sum = 0;

        while (n > 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
            System.out.println(sum);
        }

        if(sum == 1) return true;
        else return isHappy(sum);
    }
}