...
@NotBlank(message = "{global.check.username}")
@Size(min=0,max=50,message="{global.check.usernamelength}")
private String username;

@NotBlank(message = "{global.check.username}")
private String password;
...