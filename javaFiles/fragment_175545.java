public static void printWeights(int pounds) {
    int[] weights = new int[]{100, 50, 20, 10, 5, 1};
    int[] appearance = new int[6];
    for (int i = 0; i < 6; i++) {
        while (pounds >= weights[i]) {
            appearance[i]++;
            pounds -= weights[i];
        }
    }

    System.out.println(appearance[0] +" times 100 lbs");
    System.out.println(appearance[1] +" times 50 lbs");
    System.out.println(appearance[2] +" times 20 lbs");
    System.out.println(appearance[3] +" times 10 lbs");
    System.out.println(appearance[4] +" times 5 lbs");
    System.out.println(appearance[5] +" times 1 lbs" );

}
public static void main(String[] args) {
    System.out.print("How many pounds does the item weights? ");
    int pounds = input.nextInt();
    printWeights(pounds);
}
>printWeights(99);
>>0 times 100 lbs
>>1 times 50 lbs
>>2 times 20 lbs
>>0 times 10 lbs
>>1 times 5 lbs
>>4 times 1 lbs