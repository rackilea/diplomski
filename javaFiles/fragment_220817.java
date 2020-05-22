@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "children")
public class Child extends LongId {

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @ManyToOne(optional = false)
    private Reference reference;

    public Child(String reference) {
    }
}