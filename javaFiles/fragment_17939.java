int[] nums = new int[4];

for (int i = 0; i < 4; i++)
    nums[i] = dice.random(6) + 1;

Arrays.sort(nums);
finalStat = nums[1] + nums[2] + nums[3];