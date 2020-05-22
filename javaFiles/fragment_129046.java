public static void removeDog(String dogName)
{
    for(Pet pet : mainList)
        {
            if((pet instanceof Dog) && pet.getName().equals(dogName))
            {
                mainList.remove(pet);
            }//end of if statement
        }//end of for loop

}//end of removeDog method


public static void removeCat(String catName)
{
        for(Pet pet : mainList)
        {
            if((pet instanceof Cat) && pet.getName().equals(catName))
            {
                mainList.remove(pet);

            }//end of if statement

        }//end of for loop

}//end of removeCat method