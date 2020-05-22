List<Apartment> myList = new ArrayList<Apartment>();

String[] desc = new String {"123 Fake Street, 456, 3, 1500", ... }

for(int i=0; i<desc.length; i++)
{
   try
   {
      myList.add(new Apartment(desc[i]));
   }
   catch(ApartmentException mistake)
   {
      //do something
   }
}

//at this point myList contains only valid listings