public static void main(String[] args){
    int change = 0;//Total Numbers It think
    int nums = 0;//Sum

    System.out.println("Enter the numbers to find their average: ");
    Scanner num = new Scanner(System.in);//Should be moved out of loop so its not initialized every time

    int Dividend=1;//I had to declare to run it
    while (change <= Dividend) {//not sure why your comparing these

        nums = nums + num.nextInt();//Total Sum
        change++;//Total nums

        if (change == Dividend) {
            System.out.println("Average: " + nums / Dividend);
        }
        System.out.println(nums);
    }
}