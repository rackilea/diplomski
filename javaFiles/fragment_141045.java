public void add(String name, int severity) {
    lastArrival++;
    Patient patient = new Patient(name, lastArrival, severity);
    if(head == null) {
        head = new PatientNode(patient, head);
        size++;
    } else {
        PatientNode current, previous;
        current = head;
        previous = null;
        while(current!=null) {
            if(current.data.compareSeverity(patient)) {
                PatientNode n = new PatientNode(patient,current);
                size++;
                //n.next = current; // overkill
                if(previous==null) {
                    head = n;
                } else {
                    previous.next = n;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
        if(current == null){
            previous.next = new PatientNode(patient, null);
            size++;
        }
    }
}