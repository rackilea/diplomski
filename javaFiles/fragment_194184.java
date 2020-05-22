@NotNull(message="*required")
@Size(min=1)
@Column(name="FIRST_NAME")
private String firstName;

@NotNull
@Size(min=1)
@Column(name="LAST_NAME")
private String lastName;