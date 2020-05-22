public class SomeClass implements SomeInterface {

   private PetRepository petRepository;
   private VetRepository vetRepository;
   private OwnerRepository ownerRepository;
   private VisitRepository visitRepository;

   ... some methods ...

   @Resource
   public void setPetRepository(PetRepository petRepository) {
        this.petRepository= petRepository;
   }

   @Resource
   public void setVetRepository(VetRepository vetRepository) {
        this.petRepository= vetRepository;
   }

   @Resource
   public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
   }

   @Resource
   public void setVisitRepository(VisitRepository visitRepository) {
        this.visitRepository= visitRepository;
   }

}