@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "requests")
@SecondaryTable("name = "addresses")
public class Request {

    @NotNull
    @Embedded
    private Address address;
}