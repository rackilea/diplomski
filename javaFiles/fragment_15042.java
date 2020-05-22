package com.todo.api.db;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@NamedQueries({
        @NamedQuery(name = "com.todo.api.db.TodoModel.getAll", query = "select t from TodoModel t"),
        @NamedQuery(name = "com.todo.api.db.TodoModel.getById", query = "select t from TodoModel t where t.id = :id")
})
public class TodoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task")
    private String task;

    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "created_at")
    private String created_at;

    public TodoModel(){
    }

    public TodoModel(String task, Boolean completed, String created_at) {
        this.task = task;
        this.completed = completed;
        this.created_at = created_at;
    }

    public String getTask(){
        return task;
    }

    public void setTask(String task){
        this.task = task;
    }

    public Boolean getCompleted(){
        return completed;
    }

    public void setCompleted(Boolean completed){
        this.completed = completed;
    }

    public String getCreated_at(){
        return created_at;
    }

    public void setCreated_at(String created_at){
        this.created_at = created_at;
    }

}