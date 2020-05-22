Random rng = new Random();
ArrayList<Integer> numbers = new ArrayList<>();
for (int i = 0; i < 100000; ++i)
    numbers.add(rng.nextInt());

HashSet<Integer> set = new HashSet<>();
long beginNoCheck = System.nanoTime();
for (int i : numbers)
{
    set.add(i);
}
long endNoCheck = System.nanoTime();

set = new HashSet<>();
long beginCheck = System.nanoTime();
for (int i : numbers)
{
    if (!set.contains(i))
        set.add(i);
}
long endCheck = System.nanoTime();

System.out.println("Without check: " + (endNoCheck - beginNoCheck));
System.out.println("With check: " + (endCheck - beginCheck));