@NotNull(message="First name {err.required}")
@Size(min=1, message="First name {err.required}")
private String firstName;

@NotNull(message="Last name {err.required}")
@Size(min=1, message="Last name {err.required}")
private String lastName;