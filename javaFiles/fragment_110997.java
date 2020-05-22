boolean found = false;
 while(rs.next()){
              if(!user_entered_student_id.equals("ClassSelector.students.student_id")){
                 System.out.println(studentInClass); 
                 found = true;
                 break; // ??  Is this unique?
              }
  } 

  if (!found) {
      System.out.println("This Student does not Exist!");
      return false; // ???
  }
  return true; // ???