package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item extends Model {
    @Id
    public Long id;

    @ManyToOne
    public Client client;
}