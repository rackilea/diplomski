while (set1.next())
{
    System.out.print("Id: "+set1.getInt(1)+", Name: "+set1.getString(2));

    while (set2.next())
    {
        System.out.print(", Alias:");
        if (set1.getInt(1)==(set2.getInt(1)))
        {  
            System.out.print(set2.getString(2) + ", ");
            continue;
        } else {
            set2.previous();
            break;
        }
    }
    System.out.println();
}