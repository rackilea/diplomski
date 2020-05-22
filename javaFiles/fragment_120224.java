@Entity
@Table(name = "parent")
@FilterDef(name = "dateFilter", parameters = @ParamDef( name = "targetDate", type = "string" ))
public class Parent {
    @OneToMany(mappedBy = "parent")
    @Filter(name = "dateFilter", condition = "(:targetDate between to_char(startDate, 'yyyyMMdd') and to_char(endDate, 'yyyyMMdd')")
    private Collection<Child> childCollection = new HashSet<Child>();
}