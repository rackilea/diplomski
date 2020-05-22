import java.util.ArrayList;

public class StudentWrapper {
  private ArrayList<Studente> studente;

  public StudentWrapper() {
    studente = new ArrayList<Studente>();
  }

  public void addStudent(Studente s){
    studente.add(s);
  }
}