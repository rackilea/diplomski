protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";

/**
* The default query used to retrieve account data for the user when {@link #saltStyle} is COLUMN.
*/
protected static final String DEFAULT_SALTED_AUTHENTICATION_QUERY = "select password, password_salt from users where username = ?";

/**
* The default query used to retrieve the roles that apply to a user.
*/
protected static final String DEFAULT_USER_ROLES_QUERY = "select role_name from user_roles where username = ?";

/**
* The default query used to retrieve permissions that apply to a particular role.
*/
protected static final String DEFAULT_PERMISSIONS_QUERY = "select permission from roles_permissions where role_name = ?";