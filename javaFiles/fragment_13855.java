class Player {
  @Id
  @GeneratedValue
  long id;
  @Column(name = “is_star”, columnDefinition="boolean default false")
  boolean star;
  (...)
}

class SportTeam {
  @Id
  @GeneratedValue
  long id;
  @OneToMany
  private Set<PLayer> players;

  public Collection<Player> getStars() {
    // return your stars here, filter through players.
    // if you want you can do caching, but remember to set the field to @Transient
    // so that Hibernate does not think, it could be a relation
  }
}