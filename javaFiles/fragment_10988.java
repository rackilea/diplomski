count = 0 i.e. (count<5): 
i = i + i -> i = 60 + 60 = 120;
i = i + 1 -> i = 120 + 1 = 121;
j = j - 1 -> j = 50 - 1 = 49;
j = j - j -> j = 49 - 49 = 0;
count = count ++ -> count= 0 + 1 = 1;

count = 1 i.e. (count<5): 
i = i + i -> i = 121 + 121 = 242;
i = i + 1 -> i = 242 + 1 = 243;
j = j - 1 -> j = 0 - 1 = -1;
j = j - j -> j = -1 - (-1) = 0;
count = count ++ -> count= 1 + 1 = 2;

count = 2 i.e. (count<5): 
i = i + i -> i = 243 + 243 = 486;
i = i + 1 -> i = 486 + 1 = 487;
j = j - 1 -> j = 0 - 1 = -1;
j = j - j -> j = -1 - (-1) = 0;
count = count ++ -> count= 2 + 1 = 3;

count = 3 i.e. (count<5): 
i = i + i -> i = 487 + 487 = 974;
i = i + 1 -> i = 974 + 1 = 975;
j = j - 1 -> j = 0 - 1 = -1;
j = j - j -> j = -1 - (-1) = 0;
count = count ++ -> count= 3 + 1 = 4;

count = 4 i.e. (count<5): 
i = i + i -> i = 974 + 974 = 1950;
i = i + 1 -> i = 1950 + 1 = 975;
j = j - 1 -> j = 0 - 1 = -1;
j = j - j -> j = -1 - (-1) = 0;
count = count ++ -> count= 4 + 1 = 5;