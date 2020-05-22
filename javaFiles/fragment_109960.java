@Service
public class GuestService {

@PersistenceContext
private EntityManager em;

public List<Guest> findGuests(Guest searchedGuest) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Guest> cq = cb.createQuery(Guest.class);
    Root<Guest> quest = cq.from(Guest.class);
    List<Predicate> predicates = new ArrayList<Predicate>();

    if (searchedGuest.getPropertyIdentifier != null) {
        predicates.add(cb.equal(quest.get("propertyIdentifier"), searchedGuest.getPropertyIdentifier));
    }
    if (searchedGuest.getFirstName != null) {
        predicates.add(cb.like(quest.get("firstName"), "%" + searchedGuest.getFirstName + "%"));
    }
    // other predicates

    cq.select(quest).where(predicates.toArray(new Predicate[] {}));
    List<Guest> guests = em.createQuery(cq).getResultList();
    return guests;
}