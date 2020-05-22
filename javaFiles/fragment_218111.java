int itemIndex = Arrays.asList(names).indexOf(name);
if(itemIndex>=0) // instead of if(name.equals(names[count]))
{
    // rest of the codes; use the itemIndex to retrieve other information
}
else
{
    System.out.println(name + " was not found");
}