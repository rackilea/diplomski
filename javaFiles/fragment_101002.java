List<Integer> nums = new ArrayList<Integer>();
for (int i = 0; i < 13; i++)
    nums.add(i);
Collections.shuffle(nums);
for (int randomNum : nums)
    System.out.println(randomNum); // use the random numbers