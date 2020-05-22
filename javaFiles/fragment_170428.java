public void calcGPA(){
   int sum_grades = 0;
   for(int i=0; i<this.grades.size(); i++){
       sum_grades = sum_grades + this.grades.get(i);//sum the grades
   }
    gpa = sum_grades/this.grades.size();
}