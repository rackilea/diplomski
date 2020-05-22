System.out.print("How old are you? ");
int age = Integer.parseInt(scanner.nextLine());
if(age > 15)
{
    if(age == 16)
    {
        System.out.print("Do you already have a scooter license? ");
        String scooter = scanner.nextLine();
    }
    if(age > 16)
    {
        System.out.print("Do you already have a car license? ");
        String auto = scanner.nextLine();
     }
}