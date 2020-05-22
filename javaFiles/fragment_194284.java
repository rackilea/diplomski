public double getAverage(){
    if(students >= minimum){
        return studentGrades / students;
    }
    else {
       throw new IllegalStateException("not enough students");
    }
}