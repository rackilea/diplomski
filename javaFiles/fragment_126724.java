int j = 0;
// copy all the non -1 values down.
for (int i = 0; i < NB_CARD; i++)
    if (t[i] != -1)
       t[j++] = t[i];
// fill the rest with -1
Arrays.fill(t, j, NB_CARD, -1);