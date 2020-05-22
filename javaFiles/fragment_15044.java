package com.todo.api.resources;

import com.todo.api.db.TodoDAO;
import com.todo.api.db.TodoModel;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    private TodoDAO todoDao;

    public HelloResource(TodoDAO todoDao){
        this.todoDao = todoDao;
    }

    @GET
    @UnitOfWork
    public List<TodoModel> findAll(){
        return (todoDao.getAll());
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public TodoModel findId(@PathParam("id") Long id)
    {
        return todoDao.getById(id);

    }

    @POST
    @UnitOfWork
    public TodoModel post(TodoModel todoModel)
    {

        return todoDao.create(todoModel);
    }


}