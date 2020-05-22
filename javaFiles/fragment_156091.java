public class Person implements Comparable<Person> {
    // the parts of Person you already have would go here
    public int compareTo(Person person) {
        if (person == null) {
            return -1;
        }

        if (surname != null && person.getSur() == null) {
            return -1;
        } else if (surname == null && person.getSur() != null) {
            return 1;
        } else if (surname != null && person.getSur() != null) {
            int compare = surname.compareToIgnoreCase(person.getSur());
            if (compare != 0) {
                return compare;
            }
        }
        // Note that we did nothing if both surnames were null or equal

        if (name == null && person.getName() == null) {
            return 0;
        } else if (name != null && person.getName() == null) {
            return -1;
        } else if (name == null && person.getName() != null) {
            return 1;
        } else {
            return name.compareToIgnoreCase(person.getName());
        }
    }
}