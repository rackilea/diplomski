public static void main(String args[])
{
    int[] nums = new int[300];

    for (int counter = 0; counter < nums.length; counter++)
        nums[counter] = (int) (Math.random() * 300);

    int[] modes = computeModes(nums);
    for (int i : modes)
        if (i != 0) // Discard 0's
            System.out.println(i);
}