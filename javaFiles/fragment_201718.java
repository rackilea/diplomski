if (max < numbersNeeded)
{
    throw new IllegalArgumentException("Can't ask for more numbers than are available");
}
Random rng = new Random(); // Ideally just create one instance globally
// Note: use LinkedHashSet to maintain insertion order
Set<Integer> generated = new LinkedHashSet<Integer>();
while (generated.size() < numbersNeeded)
{
    Integer next = rng.nextInt(max) + 1;
    // As we're adding to a set, this will automatically do a containment check
    generated.add(next);
}