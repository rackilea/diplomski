System.out.print(prompt);
R = sc.next();
System.out.println("Email address: " + R.toString());
if (R.equals(""))
{
    System.out.println("Error! This entry is required. Try again.");
}
else
{
    isValid = true;
}