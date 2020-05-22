int[] occurrencesA = new int[10], occurrencesB = new int[10];
for(; m != 0; m /= 10)
    occurrencesA[m % 10]++;
for(; n != 0; n /= 10)
    occurrencesB[n % 10]++;
for(int i = 0; i < 10; i++)
    if(occurrencesA[i] != occurrencesB[i]) return false;
return true;