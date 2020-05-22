@Entity
public class Candidate{
    // properties, getters and setters

    @ManyToOne
    Status status;
}