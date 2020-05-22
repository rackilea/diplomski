public Student(String name, String age) 
{
  this.name = name;
  this.age = age;
  addStudent(this); //here is the call to the above method
}