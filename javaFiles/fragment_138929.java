String[] names = {"pete", "ryan", "bob", "cynthia", "ulga", "sarah", "madison"};

for(int i = 0; i < names.length; i = i + 2)
{
    System.out.print(names[i]);
    if(i + 1 < names.length)
    {
        System.out.print("\t" + names[i + 1]);
    }
    System.out.println();
}