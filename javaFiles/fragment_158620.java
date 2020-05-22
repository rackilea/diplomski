if(current.data.compareSeverity(patient)) {
    PatientNode nextHolder = current.next;
    PatientNode n = new PatientNode(patient,current);
    size++;
    n.next = current;   //this line forgotten??
    if(previous==null) {
        head = n;
    }
    else {
        previous.next = n;
    }
    return;
}


previous = current;
current = current.next;