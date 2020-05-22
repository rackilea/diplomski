public boolean findIdNumber(int idNumber){
    for(int i=0; i< students.size; i++)
          if(students.get(i).getID() == idNumber)
               return true;
          else
               return false;
}