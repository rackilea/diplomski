@Entity
public class User {

@Id
@GeneratedValue
private Integer id = 0;

private String name = null;
private String email = null;
private String password = null;

@ManyToMany(cascade = {CascadeType.ALL})
private List<Role> roles = null;

@OneToMany(mappedBy="user")
private List<Blog> blogs = null;

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

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public List<Role> getRoles() {
    return roles;
}

public void setRoles(List<Role> roles) {
    this.roles = roles;
}

public List<Blog> getBlogs() {
    return blogs;
}

public void setBlogs(List<Blog> blogs) {
    this.blogs = blogs;
}}