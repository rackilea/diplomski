boolean getAnotherPerson = true;
do
{
    System.out.println("Enter a Name ");
    // and so on.
    System.out.println("And The shortest persone is " + shortestName + " at a hight of " + shortestHight);
    System.out.println("Do you want to enter another person? Y/N ");
    answer = KB.next();
    if ("n".equalsIgnoreCase(answer) || "no".equalsIgnoreCase(answer))
    {
        getAnotherPerson = false;
    }
} while (getAnotherPerson);