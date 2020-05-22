List<Integer> numbers = new ArrayList<>();
Integer n = null;
for (String numb : myNumbers)
{
    try
    {
        n = new Integer(numb);
    }
    catch (NumberFormatException e)
    {
        System.out.println("Wrong number " + numb);
        continue;
    }
    numbers.add(n);
}
System.out.println(numbers);