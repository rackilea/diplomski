@Entity
public class Range extends Attribute {
    ...
    @OneToMany(mappedBy = "attribute")
    @JoinTable(name = "startrange_option", 
               joinColumns = @JoinColumn(name = "range_id"), 
               inverseJoinColumns = @JoinColumn(name = "option_id")
    private List<AttributeOption> startRange;
    @OneToMany(mappedBy = "attribute")
    @JoinTable(name = "endrange_option", 
               joinColumns = @JoinColumn(name = "range_id"), 
               inverseJoinColumns = @JoinColumn(name = "option_id")
    private List<AttributeOption> endRange;
    ...
}