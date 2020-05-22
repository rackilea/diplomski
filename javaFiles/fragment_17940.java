List<Integer> nums = new ArrayList<Integer>();

for (int i = 0; i < 4; i++)
    nums.add(dice.random(6) + 1);

Collections.sort(nums);
finalStat = nums.get(1) + nums.get(2) + nums.get(3);