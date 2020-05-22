//Copy constructor for the student
 Student(Student copyCons){
    this._rollNo = copyCons._rollNo;
    this._name = copyCons._name;
    this._address = copyCons._address;
    this._teacher = copyCons._teacher.clone();
}

 //Clone for the student
 protected Student clone(){
     return new Student(this);
 }