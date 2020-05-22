package com.pechen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pechen.dao.PersonDao;
import com.pechen.dao.PersonDaoImpl;
import com.pechen.entity.Person;

public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void setPersonDao(PersonDaoImpl personImpl) {
        this.personDao = personImpl;
    }

    public void savePerson(Person person) {
        // other business logic
        this.personDao.save(person);
        System.out.println("Save person successfully: " + person);
    }

    public List<Person> getPersons() {
        // other business logic
        return this.personDao.list();
    }

}