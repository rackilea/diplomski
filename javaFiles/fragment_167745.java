if (StudentlName.equalsIgnoreCase(lName[index])  )

      {
          System.out.println(course+"\n"+
                  "Student ID = \t"+index+"\n"+ 
                  unitTitle + "\n" +
                  fName[index] + "\n"  + 
                  lName[index] + "\n" + 
                  Marks[index] + "\n" + "\n" );
          found = false;
          break; //this will break outta the for-loop
      }