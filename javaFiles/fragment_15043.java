package com.todo.api.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TodoDAO extends AbstractDAO<TodoModel> {
    public TodoDAO(SessionFactory factory) {
        super(factory);
    }

    public TodoModel create(TodoModel todoModel){
        return persist(todoModel);
    }

    public List<TodoModel> getAll(){
        final Criteria c = criteria();
        List results = c.list();
        return results;
    }
    public TodoModel getById(Long id){
        final Criteria c = criteria();
        c.add(Restrictions.eq("id", id));

        final List<TodoModel> todoModels = c.list();

        return todoModels.get(0);

    }
}