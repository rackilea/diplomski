public class Blood {
    ...

    public String toString() {
        return String.format("%s %s", systolic,diastolic) + day.toString();
    }

    ...
}