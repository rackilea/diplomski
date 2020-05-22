static int i;
static int N = 5;
static int[] userNum = new int[N];

public static int sumUser(int newArray[], int index) {
    if (index >= newArray.length) {
        return 0;
    }
    int ans = newArray[index] + sumUser(newArray, index + 1);

    return ans;

}

public static void main(String[] args) {
    // TODO Auto-generated method stub
    userNum = new int[] {1, 2, 3, 4, 5};
    System.out.println("The sum of your numbers is: " + sumUser(userNum, 0));

}