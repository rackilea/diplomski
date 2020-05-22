System.out.print("Enter 901 number: ");
int studentID = Integer.parseInt(myScanner.nextLine());
for(Student student : sList){
   if(student.getStudentID == studentId){
     System.out.println(student); 
     break; // As student Id is unique.So, once we found the student no need to loop further.
   }
}