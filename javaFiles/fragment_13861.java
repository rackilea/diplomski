public static void countArray(int[][] nums)
{
  int total=0;

  for (int row=0;row<nums.length;row++)
    for (int col=0;col<nums[0].length;col++)
      total += nums[row][col];

  System.out.println(total);
}