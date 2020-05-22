public int compareTo(Person otherPerson) {
    int cmp = firstName.compareTo(otherPerson.firstName);
    if(cmp != 0) return cmp;

    cmp = lastName.compareTo(otherPerson.lastName);
    if(cmp != 0) return cmp;

     return mobile.compareTo(otherPerson.mobile);
}