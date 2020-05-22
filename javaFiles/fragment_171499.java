@Entity
public class Category {

@Id
@GeneratedValue
private Integer id;

private String name;

@ManyToMany(mappedBy = "categories", cascade = { CascadeType.MERGE })
private List<Job> jobs;

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Category other = (Category) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}