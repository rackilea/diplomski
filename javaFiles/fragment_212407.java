System.out.println("\n\nFemale students are:");  
for(int i=0; i < student.length; i++){ 
    if (student[i].getGender() == false) {
       System.out.println( "Student " + (i+1) + " Name :: " + student[i].getName() + ", Student ID :: " + student[i].getIdNumber());
    }
}