public int[] probs;

public void genRolls(int sum, List<Integer> sides)
{
    if (sides.size() == 0)
    {
        probs[sum]++;
        return;
    }
    int top = sides.get(0);
    for (int x = 1; x <= top; x++)
        genRolls(sum+x, sides.subList(1, sides.size()));
}

public void diceprob(int target, List<Integer> sides)
{
    int maxval = 0;
    double possibilities = 1;
    for (Integer i : sides)
    {
        maxval+= i;
        possibilities *= i;
    }
    probs = new int[maxval+1];
    genRolls(0, sides);
    System.out.println("Probability is " + (probs[target]/possibilities));
}