Iterator<Contributor> nameIter = contributorList.iterator(); 
  boolean result = false;
  String searchName;
  System.out.println("Enter the first name of the contributor you are searching: ");
  searchName = in.next().toLowerCase().trim();//it is not necessary to use another variable to downcasing  
        //and add .trim () to get rid of blank spaces that may have strings    
  while (nameIter.hasNext()){                 
      contributorData = nameIter.next();
      if (contributorData.getFirstName().trim().toLowerCase().equals(searchName)){
          System.out.println("\nThe following contributor was found:\n");
          System.out.printf("%-10s %-10s %-8s %-15s %-17s %s %n", "First", "Last",
                            "Country", "Phone #", "Contribution", "ID");
          contributorData.Print(); 
          //break ;if you only want to get the first match uncomment


      }           
  }
  if (result == false){
      System.out.println("\nSorry, but that name was not found!");
  }