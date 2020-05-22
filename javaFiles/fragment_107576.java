@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class User extends AbstractEntity {

    /* non-significant attributes are omitted */

    @Setter(AccessLevel.PRIVATE)
    @Unowned
    @OneToMany(mappedBy="attendee", cascade = CascadeType.ALL)
    private List<EventUserAssociation> events = new ArrayList<>();

    public static User find(String attribute, EntityManager em) {
        /* implementation omitted */
    }

}