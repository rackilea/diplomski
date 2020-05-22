int arryNum[] = { 2, 3, 4, 5, 4, 4, 3 };
int[] counter = new int[] { 0, 0, 0, 0, 0 };
for (int i = 0; i < arryNum.length; i++) {
    counter[arryNum[i] - 1]++;
}

for (int i = 0; i < counter.length; i++)
    System.out.println((i + 1) + ":" + counter[i]);