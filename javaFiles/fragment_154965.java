@Table(
    uniqueConstraints=
        @UniqueConstraint(columnNames={"author_id", "number"})
)
@Entity
class Book extends Model {
   @ManyToOne
   @JoinColumn(name = "author_id")
   User author;
   int number; 
}