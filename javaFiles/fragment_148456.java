import java.util.Comparator;
import java.util.PriorityQueue;

public class PatientQueue {
    PriorityQueue pq;

    // default constructor
    public PatientQueue() {
        this.pq = new PriorityQueue<Patient>(1, new PatientComparator());
    }

    public void registerPatient(Patient p) {
        this.pq.add(p);
    } // end registerPatient method

    public Patient getNextPatient() {
        return (Patient) this.pq.poll();
    } // end getNextPatient method

} // end PatientQueue class