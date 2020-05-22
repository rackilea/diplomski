@Entity
public class Card extends Model {
    ...
    @OneToMany(mappedBy = "card")
    @OrderBy("position asc")
    public List<FinalMark> finalMarks;
    ...
}