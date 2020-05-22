int []nums = {1,3,6};
int max = nums.length - 1;
int min = 0;
Random rand = new Random();
int randomNum = rand.nextInt((max - min) + 1) + min;
System.out.println(nums[randomNum]);