public List<Integer> getFactors(int num) {
    List<Integer> factors = new ArrayList<>();
    for (int i = 1 ; i<num ; i++)
    {
        if (num % i == 0)
        {
            factors.add(i);
        }
    }
    return factors;
}

public static void main(String[] args) {
    System.out.println(Arrays.toString(new factors(20).getFactors());
    // prints a comma-separated list of all factors
}