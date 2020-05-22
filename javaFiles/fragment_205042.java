@Entity
public class Role {
@Id
@GeneratedValue
private Integer id = 0;

private String name = null;

@ManyToMany(cascade = {CascadeType.ALL}) 
@JoinTable
private List<User> users = null;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public List<User> getUsers() {
    return users;
}

public void setUsers(List<User> users) {
    this.users = users;
} }