public static void main(String[] args){
ArrayList<String> allItems = new ArrayList<>();
int numberOfItems = 6;
Scanner one = new Scanner(System.in);

System.out.println("Champion: ");
String champion = one.nextLine();

for(int i = 0; i < numberOfItems; i++)
{
    System.out.println("Item " + (i + 1) + ": ");
    String item = one.nextLine();
    System.out.println("Adding item: " + item + " to index " + i + " of the list");
    allItems.add(item);
}
int totalhealth = 0;
int totalad = 0;
int totalap = 0;
int totalarmor = 0;
int totalmr = 0;
int totalcdr = 0;
int totalmana = 0;
int totalcstr= 0;
int totalls = 0;
int totalatcksp = 0;
int totalcost = 0;

for(int i = 0; i < allItems.size(); i++)
{   
    if(allItems.get(i).equals("abyssal mask"))
    {
        totalhealth += 350;
        totalmana += 300;
        totalmr += 55;
        totalcdr += 10;
        totalcost += 2900;
    }
    else if(allItems.get(i).equals("adaptive helm"))
    {
        totalhealth += 350;
        totalmr += 55;
        totalcdr += 10;
        totalcost += 2800;
    }
    //... for all the items using the += for total values
    else {
        System.out.println("Not a valid item: " + allItems.get(i));
        allItems.remove(i);
        i--;
    }
}

System.out.println("Champion: " + champion);
System.out.println("Total health: " + totalhealth);
System.out.println("Total AD: " + totalad);
System.out.println("Total AP: " + totalap);
System.out.println("Total armor: " + totalarmor);
System.out.println("Total magic resist " + totalmr);
System.out.println("Total CDR: %" + totalcdr);
System.out.println("Total mana: " + totalmana);
System.out.println("Total Critical Strike Chance: " + totalcstr);
System.out.println("Total Life Steal: %" + totalls);
System.out.println("Total Attack Speed: " + totalatcksp);
System.out.println("Total Cost: " + totalcost + "g");
}