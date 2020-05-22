@Entity
@Inheritance
public abstract class Fruit {
   private Set<Note> notes;
   ...

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "fruit")
   public Set<Note> getNotes() {
       return notes;
   }
}

@Entity
public class Apple extends Fruit {
   ...
}


@Entity
public class Orange extends Fruit {
   ...
}

@Entity
public class Note {
   private String theNote;

   @ManyToOne
   private Fruit fruit;
   ...
}