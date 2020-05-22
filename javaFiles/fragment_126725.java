int[] t = {3, -1, -1, -1, 4, 5, 6, -1, -1};
int j = 0;
// copy all the non -1 values down.
for (int i : t)
    if (i != -1)
       t[j++] = i;
// fill the rest with -1
Arrays.fill(t, j, t.length, -1);

System.out.println(Arrays.toString(t));