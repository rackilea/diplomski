@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="emp_id)")
public int getId() {
    return id;
}

should be - 

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="emp_id")
public int getId() {
    return id;
}