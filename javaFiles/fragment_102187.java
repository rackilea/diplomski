String[] numString = next.split("\\s+");
int[] nums = new int[numString.length];

for (int i = 0; i < numString.length; i++){
    nums[i] = Integer.parseInt(numString[i].trim());
}

System.out.println(Arrays.toString(nums));