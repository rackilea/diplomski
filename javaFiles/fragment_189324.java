@ManyToOne
@JoinColumn(name = "user_Id")
@ForeignKey(name = "license_users_fk")
public User getUser() {
    return user;
}

@ManyToOne
@JoinColumn(name = "key_acct_mgr_id")
@ForeignKey(name = "license_kam_fk")
public User getKeyAccountManager() {
    return keyAccountManager;
}