import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class GuavaExample {
    static class Person{
        int age;
        String name;
        boolean isFemale;

        Person(int age, String name, boolean isFemale){
            this.age = age;
            this.name = name;
            this.isFemale = isFemale;
        }
    }

    public static <T> List<T> applyFilter(List<? extends T> list, Predicate<? super T> ... filters){
        // default case: no filters.
        if (filters == null || filters.length == 0)
            return new ArrayList<T>(list);

        Iterable<? extends T> it = Iterables.filter(list,Predicates.and(filters));
        return Lists.newArrayList(it);
    }

    public static <T> List<T> applyFilter(List<? extends T> list, Predicate<? super T>  filter){
        Iterable<? extends T> it = Iterables.filter(list,filter);
        return Lists.newArrayList(it);
    }


    public static void main(String[] args) {
        List<Person> result;
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person(8, "Little John",false));
        persons.add(new Person(10, "Alice Jnr.",true));
        persons.add(new Person(20,"John",false));
        persons.add(new Person(25,"Alice",true));
        persons.add(new Person(30,"Sarah",true));
        persons.add(new Person(25,"Stefan",false));


        Predicate<Person> isAdult = new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.age >= 18;
            }
        };

        Predicate<Person> isFemale = new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.isFemale;
            }
        };

        result = applyFilter(persons,isAdult);
        System.out.println("Adults: ");
        for(Person p : result)
            System.out.println(p.name);

        result = applyFilter(persons,Predicates.not(isAdult));
        System.out.println("Children: ");
        for(Person p : result)
            System.out.println(p.name);

        // Generic varargs will yield a warning, unfortionally...
        result = applyFilter(persons, isAdult, isFemale);
        System.out.println("Adult females: ");
        for(Person p : result)
            System.out.println(p.name);
    }
}