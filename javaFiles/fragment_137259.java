interface PetsRepository extends JpaRepository<Pets, Long> {}

@Path("/pets")
class PetsResource {
  @Autowired
  private PetsRepository repo;
}