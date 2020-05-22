int[] A = readPlayerOne();
int[] B = readPlayerTwo();

int draws = 0;
int wins = 0;

for(int i = 0; i < N; i++)
{
    if(A[i] == B[i])
        draws++;
    else if(A[i] - 1 == B[i] || A[i] == 1 && B[i] == 3)
        //wins according to the first configuration
        wins++;
}

return max(N - draws - wins, wins);