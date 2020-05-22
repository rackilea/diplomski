@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "username", nullable = false)
@JsonIgnore
public User getUser() {
    return this.user;
}