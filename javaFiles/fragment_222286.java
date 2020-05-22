Course maths = new Course("Maths");
Course physics = new Course("Physics");

Set<Course> courses = new HashSet<Course>();
Set<Course> courses1 = new HashSet<Course>();

courses.add(maths);
Student st1 = new Student("ABCD", courses);
session.save(st1);

courses1.add(maths);
courses1.add(physics);
Student st2 = new Student("EFGH", courses1);
session.save(st2);