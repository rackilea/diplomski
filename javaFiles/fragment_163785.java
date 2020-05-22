char[] actual = // Read in the real value
char[] guess = // Read in the users guess

int blackCount = 0;
int whiteCount = 0;

boolean[] isFound = new boolean[4];

// Black phase
for (int i = 0; i < 4; ++i)
{
  if (actual[i] == guess[i])
  {
    isFound[i] = true;
    blackCount++;
  }
}