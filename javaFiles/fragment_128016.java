@Override
public int compareTo(Patient t) {
    int patientSeriouness = t.seriousness;
    Date arrival = t.date;
    if (this.seriousness == patientSeriouness) {
        return this.date.compareTo(arrival);
    } else {
        return ((Integer)this.seriousness).compareTo(patientSeriouness);
    }
}