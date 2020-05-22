@Email(groups = NullAllowed.class) //email allows null, so you are good
private String email;

@NotNull //skip this check - not assigned to NullAllowed.class
@Size(min=1, groups = NullAllowed.class)
private String name;