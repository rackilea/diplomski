package com.example.eclipselink.entity;

import com.example.eclipselink.converter.UUIDAttributeConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Todo {

    @Id
    @Convert(converter = UUIDAttributeConverter.class)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}