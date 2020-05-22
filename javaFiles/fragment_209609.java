package com.stackoverflow.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

public class PersonTest {
    public class Person {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void testNameBasedFiltering() {
        Person bob = createPerson("bob");
        Person jim = createPerson("jim");
        Person pam = createPerson("pam");
        Person roy = createPerson("roy");

        ImmutableList<Person> persons = ImmutableList.of(
                bob,
                jim,
                pam,
                roy); 
        ImmutableList<Person> subsetOfPersons = ImmutableList.of(
                createPerson("jim"),
                createPerson("pam"));

        Function<Person, String> personToNamefunction = new Function<Person, String>() {
            public String apply(Person arg0) {
                return arg0.getName();
            }
        };

        Iterable<Person> filtered = Iterables
                .filter(
                    persons, 
                    Predicates.not(
                        Predicates.compose(
                            Predicates.in(ImmutableSet.copyOf(Iterables.transform(subsetOfPersons, personToNamefunction))),
                            personToNamefunction
                        )
                    )
                );

        for (Person person : filtered) {
            assertNotSame(jim, person);
            assertNotSame(pam, person);         
        }
    }

    public Person createPerson(String name) {
        Person person = new Person();
        person.setName(name);

        return person;
    }

}