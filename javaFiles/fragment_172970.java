public static void main(String[] args) {

        String apple = "apple";
        int[] arr = new int[26];
        String matchStr = "abcdefghijklmnopqrstuvwxyz";
        char[] charArr = matchStr.toCharArray();

        for(int i = 0 ; i < arr.length ; i ++) {
            if(apple.startsWith(charArr[i] + "")) {
                arr[i]+= 1;
            }
        }

        for(int i = 0 ; i < charArr.length ; i ++) {
            System.out.println("The number of words that start with " + charArr[i] + " - " + arr[i]);
        }
    }