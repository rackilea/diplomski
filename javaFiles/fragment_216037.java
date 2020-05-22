public int compare(Object o1, Object 02)
{
   Person p1 = (Person)o1;
   Person p2 = (Person)o2;
   // if last names are the same compare first names
   if(p1.getLastName().equals(p2.getLastName()))
   {
       return p1.getFirstName().compareTo(p2.getFirstName());
   }
   return p1.getLastName().compareTo(p2.getLastName());

}