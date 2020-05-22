package model;

/**
 * A model object that's interesting from your problem's point of view
 */
public class Foo
{
}

package persistence;

/**
 * CRUD operations for a Foo 
 */
public interface FooDao
{
    Foo find(Long id);
    List<Foo> find();
    void saveOrUpdate(Foo foo);
    void delete(Foo foo);
}


package service;

/**
 * Just a data service that wraps FooDao for now, but other use cases would 
 * mean other methods.  The service would also own the data connection and manage 
 * transactions.
 */
public interface FooService
{
    Foo find(Long id);
    List<Foo> find();
    void saveOrUpdate(Foo foo);
    void delete(Foo foo);
}

package view;

/**
 * A class that owns services, validates and binds input from UI, and handles routing 
 * to the next view once service is complete.
 */
public interface FooController
{
   ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response);    
}