@NoArgsConstructor
@Embeddable
@Getter
@Setter
public class Address {

    @Column(name="town", table="addresses")
    private String town;
}