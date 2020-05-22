int number = sc.nextInt();
if (number % five == 0)
{
    if (number % seven == 0)
        System.out.println(number + " is divisible by both 5 and 7.");
    else
        System.out.println(number + " is divisible by 5.");
}
else {
    if (number % seven == 0)
        System.out.println(number + " is divisible by 7.");
    else
        System.out.println(number + " is not divisible by either 5 or 7.");
}