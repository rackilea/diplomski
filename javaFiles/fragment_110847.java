package com.pechen.dao;

import java.util.List;

import com.pechen.entity.Person;

public interface PersonDao {

    public void save(Person p);

    public List<Person> list();

}