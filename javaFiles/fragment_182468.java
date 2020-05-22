@Override
public int compareTo(Object o) {
    if (!(o instanceof Patient))
        return -1;
    Patient temp = (Patient) o;
    int r = this.lastName.compareToIgnoreCase(temp.getLastName());
    if (r == 0)
        r = this.firstName.compareToIgnoreCase(temp.getFirstName());
    if (r == 0)
        r = this.SSN.compareToIgnoreCase(temp.getSSN());
    if (r == 0)
        r = this.dob.toString().compareToIgnoreCase(temp.getDOB().toString());
    if (r == 0)
        r = Integer.compare(this.getID(), temp.getID());
    return r;
}