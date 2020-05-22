boolean isDeleted = false;
for(int i=0;i<laptop.size();i++)
{
     if(serialno.equals(laptop.get(i).getSerialno()))
     {
         laptop.remove(i);
         isDeleted = true;
         break;
     }
}

if(isDeleted)
{
     System.out.println("Deleted");
}
else
{
     System.out.println("Laptop not found in the list");
 }