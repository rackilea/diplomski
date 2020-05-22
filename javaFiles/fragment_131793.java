class Cafeteria {
   @OneToMany(mappedBy="cafeteria")
   @LazyCollection(value=LazyCollectionOption.EXTRA)
   List<Chair> chairs;

   @OneToMany(fetch = FetchType.EAGER, mappedBy="cafeteria")
   List<Chair> eagerlyLoadedChairs;
}