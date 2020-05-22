public enum Status {
   INPATIENT,
   OUTPATIENT,
   EMERGENCY;
}

public class Patient {
    private Status status;

    public void setStatus(final Status status) {
        this.status = status;
    }
}

public class SomeService {
     public void someMethod(final Patient patient) {
         patient.setStatus(Status.INPATIENT);
         patient.setStatus(Status.OUTPATIENT);
         patient.setStatus(Status.EMERGENCY);
    }
}