if (data.moveToFirst())
{
      do
      {
           observation = data.getString(1);

           if (editing.equals("yes")) 
           {
                stringarray2 //random word here?
                Boolean test = false;
                for (String name:stringarray2)
                {
                    if (observation.equals(name))
                    {
                        test = true; 
                        break;
                    }
                }
                Country country = new Country(null,observation,test);
                countryList.add(country);
            }
            else
            {
               Country country = new Country(null,observation,false);
               countryList.add(country);
            }
      }
      while (data.moveToNext())
}