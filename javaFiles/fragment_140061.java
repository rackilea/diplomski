class Lecturers {

  public static ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();

  public static void addLecturer(Lecturer lecturer) {
    lecturers.add(lecturer);
  }

  public static void main(String[] args) {
    Lecturer one = new Lecturer(...)
    addLecturer(one);
  }
}


// you should extend a super Lecturer type
class Lecturer extends ... {

public Lecturer(String name, String id, String address, String email,   String office, String phone_number, String research, Module mod) {
    super(name, id, address, email, office, phone_number);
    this.research = research;
    this.mod = mod;
  }
}