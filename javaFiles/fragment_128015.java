public void SortPatient() {
if (firstNode == null) {
    return;
}

boolean swapped;
Node patient;

do {
    swapped = false;
    patient = firstNode;
    while (patient.next != null) {
        if (patient.data.compareTo(patient.next.data) > 0) {
            swap(patient, patient.next);
            swapped = true;
        }
        patient = patient.next;
    }
} while (swapped);
}


private void swap(Node patient, Node nextPatient) {
    T temp = patient.data;
    patient.data = nextPatient.data;
    nextPatient.data = temp;
}