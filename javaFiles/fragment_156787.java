class Student{ 
   private String name, ID;
   private int gpa, age;
   //More personalia stuff...

   private ArrayList<Subject> subjects;

   public void addSubject (Subject new_subject) { subjects.add(new_subject); }
   public void addSubjects (List <Subject> subjects_list) {
       for (Subject s : subjects_list) addSubject(s);
   }

   //Getters 
   public int getGPA() { return gpa; }
   public int getAge() { return age; }
   public String getName() { return name; }

   //.. More personalia getters

   //Setters 
   public void setGPA(int new_gpa) { gpa = new_gpa; }



 }

class Subject { 
    String description;
    String ID;

}