import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class ContactPredicate {
    private static QContact contact = QContact.contact;
    private ContactPredicate() {}

    public static Predicate forCriteria(ContactCriteria criteria) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (criteria.getType() != null) {
            predicate.and(contact.type.eq(criteria.getType()));
        }
        if (criteria.getVal() != null) {
            predicate.and(contact.val.eq(criteria.getVal()));
       }
       return predicate;
    }

}