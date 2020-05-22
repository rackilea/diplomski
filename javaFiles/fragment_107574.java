@Entity 
@Table(name = "event_user_response")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true, exclude = {"attendee", "event"})
public class EventUserAssociation extends AbstractEntity {

    @Unowned
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "eventId", referencedColumnName = "_id")
    private Event event;

    @Unowned
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "attendeeId", referencedColumnName = "_id")
    private User attendee;

    @Enumerated
    private Response response;

}