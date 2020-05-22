public class SomeClassTestCase {

  @Mock 
  private PetRepository petRepository;

  @Mock 
  private VetRepository vetRepository;

  @Mock 
  private OwnerRepository ownerRepository;

  @Mock 
  private VisitRepository visitRepository;

  private SomeClass someClass;

  @Before
  public void before(){
     MockitoAnnotations.initMocks(this);
     someClass = new SomeClass();
     someClass.setPetRepository(petRepository);
     someClass.setVetRepository(vetRepository);
     someClass.setOwnerRepository(ownerRepository);
     someClass.setVisitRepository(visitRepository);
  }

  @Test
  public void someTest() {
    ...
  }

}