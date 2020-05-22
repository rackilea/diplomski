public interface UserOfferMappingRepository extends JpaRepository<UserOfferMapping, Integer> {
    public List<UserOfferMapping> getAllByUser(Optional<User> user);

    public UserOfferMapping getUserOfferMappingByUserAndProjectAndUserRole(User user, Userproject userproject, Userrole userrole);

    public UserOfferMapping getById(int id);

   // public void deleteById(int id);

   @Modifying(clearAutomatically = true)
  @Query(value = "Delete from UserOfferMapping c WHERE c.id=:id")
  public void deleteById(@Param("id") int id);
}