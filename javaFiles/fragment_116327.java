package org.mongodb.morphia;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import java.io.Serializable;

@Entity("Input")
public class Input implements Serializable {
    @Id
    private ObjectId id;
    private String title;
  //Getters and Setters
}