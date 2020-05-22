public void readAndReplace()
    {
      // You can also create a new list out of the existing list.
      // That way, you won't need to modify the existing one.
      List<String> newList = new ArrayList<String>();
      for(int i = 0; i < someList .size(); i++)
      {
          if(someList.get(i).contains(someString))
          {
              newList.add(someList.get(i).replace(someString, otherString));
             //someList.set(i, someList.get(i).replace(someString, otherString));
          } else {

              // If it not contains `someString`, add it as it is to newList
              newList.add(someList.get(i));
          }

       }
       System.out.println(someList);  // Original
       System.out.println(newList);   // New List

    }