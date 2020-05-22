public void increment(int... increment)
{
    for(int i = 1; i < increment.length; i++){
      increment[i] = 1;
    }
}