package collections;

/**
 * Person
 * @author Michael
 * @link  https://stackoverflow.com/questions/30958832/java-how-create-a-set-of-object-with-two-classes
 * @since 6/20/2015 5:06 PM
 */
public class Person {
    private final String name;

    public Person(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException("name cannot be blank or null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name.equals(person.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * City
 * @author Michael
 * @link  https://stackoverflow.com/questions/30958832/java-how-create-a-set-of-object-with-two-classes
 * @since 6/20/2015 5:06 PM
 */
public class City {

    private Set<Person> inhabitants;

    public City(Collection<Person> inhabitants) {
        this.inhabitants = (inhabitants == null) ? new HashSet<Person>() : new HashSet<Person>(inhabitants);
    }

    public void addInhabitant(Person p) {
        if (p != null) {
            this.inhabitants.add(p);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("inhabitants=").append(inhabitants);
        sb.append('}');
        return sb.toString();
    }
}