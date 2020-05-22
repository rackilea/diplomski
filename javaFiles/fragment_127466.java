create table profile(
   userId INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   equipment_id     INT  default NULL,
   tennis_racket_id     INT  default NULL,
   PRIMARY KEY (userId)
);

create table equipment(
   id INT NOT NULL auto_increment,
--other columns your class has 
   PRIMARY KEY (id)
);

create table tennis_racket(
   id INT NOT NULL auto_increment,
--other columns your class has 
   PRIMARY KEY (id)
);

if you use JPA you can use following entity classes 

 @Entity
 @Table(name = "profile")
 public class Profile{
      private long userId;
      private String firstName;
      private String lastName;
      @ManyToOne
      @JoinColumn(name="equipment_id", nullable=false)
      private Equipment equipment;
      @ManyToOne
      @JoinColumn(name="tennis_racket_id", nullable=false)
      private TennisRacket tennisRacket;
  }

 @Entity
 @Table(name = "equipment")
 public class Equipment {
      private long Id;
        //add other attributes
  }

 @Entity
 @Table(name = "tennis_racket")
 public class TennisRacket{
      private long Id;
    //add other attributes
  }