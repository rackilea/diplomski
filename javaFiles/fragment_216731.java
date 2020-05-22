//User table
@Id
Long id; 
@OneToMany(mappedBy="user",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
@SortNatural
SortedSet<Project> projects;

@OneToOne(mappedBy="user", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
Company company;

//Project table
@Id
Long id;
@ManyToOne
@JoinColumn(name="user_id")
User user;

//Company table
@Id
Long id;
@OneToOne
@JoinColumn(name="user_id")
User user;
String name;