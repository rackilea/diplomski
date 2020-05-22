System.out.print("[" + i + "]" + "  ");
for(int j = 0; j < amountRoles[i]; j++) // Loop through amountRoles[i]
{
    if (Math.round(j) % 100 == 0)
    {
        System.out.print("" + "*");
    }
}
System.out.println(" "  + amountRoles[i]);