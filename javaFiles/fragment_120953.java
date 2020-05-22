public class Cat {
  ...
  @OneToMany(mappedBy="cat", fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @LazyCollection(LazyCollectionOption.EXTRA)
  @Getter
  @Setter
  private Set<Kitten> kittens = new HashSet();
  public void addKitten(Kitten k) {
     k.setCat(this);
     if (Hibernate.isInitialized(kittens)) kittens.add(k); //line X
  }
  ...
}  

public class Kitten {
  ...   
  @ManyToOne(fetch=FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @Getter
  @Setter
  private Cat cat;
  ...
}