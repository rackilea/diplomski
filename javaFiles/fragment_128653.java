@Override
public int compare(Athlete o1, Athlete o2) {
    int diffLastName = o1.getLastName().compareTo(o2.getLastName());
    if (diffLastName == 0) { // last names are equal
        return o1.getFirstName().compareTo(o2.getFirstName());
    } else {
        return diffLastName;
    }
}