@Entity
public class Lib implements Serializable {
      @OneToMany
      private Set<Book> books;
}

@Entity
public class Book implements Serializable {
      @OneToOne
      private Lib lib;
}