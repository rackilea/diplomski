/** The user token. */
@OneToOne(mappedBy = "user")
private Token token; 

@OneToOne(mappedBy = "token")
private User user;