@Entity
@Table(name = "ACTION_BUTTON", schema = "CHKL_APP")
public class ButtonAction implements Serializable {
    @Id
    @Column(name = "checklist_item_id", unique = true, nullable = false, insertable = true, updatable = false)
    private Long checklistItemId;

    @OneToOne
    @MapsId
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private ChecklistItem checklistItem;

    //...
}