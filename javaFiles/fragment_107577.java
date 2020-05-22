@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode
public abstract class AbstractEntity {

    @Id 
    @Column(name = "_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    protected Key id;

}