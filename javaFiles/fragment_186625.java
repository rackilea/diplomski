/**
 * Removes the {@code Person} with the given {@code name} from the list
 * @param name the {@code Person}'s name
 * @return the {@code Person} removed from the list or {@code null} if not found
 */
public Person removePerson(String name) {
    if (name != null) {
        for (Iterator<Person> iter = people.iterator(); iter.hasNext(); ) {
            Person person = iter.next();
            if (name.equalsIgnoreCase(person.getName())) {
                iter.remove();
                return person;
            }
        }
    }
    return null;
}