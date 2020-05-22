//Outside the loop
int duplicates = 0;    

//Inside the loop
if (!s.add(token))
{
    duplicates++;
    System.out.println("Duplicate detected: " + token);
}

//Outside the loop
System.out.println(duplicates);