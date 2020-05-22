@Service
public class PersonTypeService {
    @Value("${threshold.for.adulthood}")
    private int thresholdForAdulthood;

    public PersonType determinePersonType(final Person person) {
        if (person.getAge() >= thresholdForAdulthood) {
            return PersonType.ADULT;
        }
        return PersonType.CHILD;
    }  
}