@ManyToMany
@JoinTable(name="Game_admins", joinColumns = {
      @JoinColumn(name="admins_id")           
  },
inverseJoinColumns = {
  @JoinColumn(name="Game_id")
}
private Set<User> admins = new HashSet<User>();