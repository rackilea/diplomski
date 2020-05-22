private static void AddStudent() {

   // ... the code where you obtain user information

   if(index < students.length) {  // make sure there is room to add the user
       Student student = new Student(/* add user information into the constructor */);
       students[index] = student; // add the user at the index 
       index++;                   // update the index
   } else {
       System.err.println("No more room for students");
   }
}