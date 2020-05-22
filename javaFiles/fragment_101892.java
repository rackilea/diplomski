@OneToMany    
@JoinColumn(name = "first_column")
private User customer; 

@OneToMany    
@JoinColumn(name = "second_column")
private User user;