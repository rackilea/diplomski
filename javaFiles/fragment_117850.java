public void addPerson(Person person) {
    if (list.isEmpty()) {
        list.add(p);
    } else {
        // the position where you will insert the Person;
        // default value is list.size(), so it can be added to the end
        int position = list.size();

        Person p;
        for (int i = 0; i < list.size(); i++) {
            p = list.get(i);

            // if the comparison result is > 0, you found the first Person
            // in the list that comes alphabetically after;
            // Insert person before it, at position i
            if (compare(p, person) > 0) {
                position = i;
                break; // only break now that you've found the insert position
            }
        }
        list.add(person, position);
    }
}

/**
 * @return 0 if both Persons p1 & p2 have the same names, 
 *         a positive number if p1 is lexicographically greater than p2, 
 *         or a negative number if p1 is lexicographically less than p2 
 */
private int compare(Person p1, Person p2) {
    int result = p1.getLastName().compareTo(p2.getLastName());
    if (result == 0) {
        result = p1.getFirstName().compareTo(p2.getFirstName());
    }
    return result;
}