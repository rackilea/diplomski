@Element(value = Student.class)
@Key(value = Integer.class)
@KeyProperty(value = "id") 
@CreateIfNull(value = true)
private Set<Student> students = new HashSet(0);
//getter and setter, also for Student class that should have Integer id.