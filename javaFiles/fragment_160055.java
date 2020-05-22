long maximumGroupCode = encode(numberMap);
int [] optimalNumberOfGroups = new int[maximumGroupCode];
int maximumNumberOfGroups = 0;
for (long i = 0; i < maximumGroupCode; i++) {
   if (i != 0 && optimalNumberOfGroups[i] == 0) {
     continue;
   }
   int [] decodedGroup = decode(i);
   group_for: for (Long subgroupCode : subgroupsSumG) {
       int [] subgroup = decode(subgroupCode);
       for (int j = 5; j <= 20; j++) {
          if (numberMap[j] < decodedGroup[j] + subgroup[j]) {
              continue group_for;
          }
       }
       long neighbouringGroupCode = subgroupCode + i;
       optimalNumberOfGroups[neighbouringGroupCode] = Math.max(optimalNumberOfGroups[neighbouringGroupCode], optimalNumberOfGroups[i] + 1);
       maximumNumberOfGroups = Math.max(maximumNumberOfGroups, optimalNumberOfGroups[neighbouringGroupCode]);
    }
}