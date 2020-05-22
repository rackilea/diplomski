public static boolean searchSum(ArrayList<Long> array, long elem) {

    BigInteger bigElem = BigInteger.valueOf(elem);        
    int left = 0, right = array.size() - 1;

    while (left < right) {
        BigInteger n1 = BigInteger.valueOf(array.get(left));
        BigInteger n2 = BigInteger.valueOf(array.get(right));
        BigInteger sum = n1.add(n2);

        if (sum.equals(bigElem)) {
            return true;
        } else if (sum.compareTo(bigElem) < 0) {
            left++;
        } else {
            right--;
        }
    }
    return false;
}