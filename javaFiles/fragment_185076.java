//Outside the loop
Set<String> duplicates = new HashSet<String>();

//Inside the loop
if (!s.add(token))
{
    duplicates.add(token);
    System.out.println("Duplicate detected: " + token);
}

//Outside the loop
System.out.println(duplicates.size());