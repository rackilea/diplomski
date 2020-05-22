List<Long> subgroupsSumG = new ArrayList<Long>();

recursion(5, new int[21], 0);

void recursion(int currentIndex, int [] subgroup, int sum) {
  if (currentIndex == 21) {
     if (sum == G) {
        subgroupSumG.add(encode(subgroup));
     }
     return;
  }
  if (sum > G) {
     return;
  }
  for (int i = 0; i <= numberMap[currentIndex]; i++) {
     subgroup[currentIndex] = i;
     recursion(currentIndex + 1, subgroup, sum + i * currentIndex);
  }
}