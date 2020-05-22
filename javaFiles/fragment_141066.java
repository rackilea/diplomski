@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RouteEntityPk.class)
@Table(name = "ROUTE", schema = "NAV")
public class RouteEntity {

    @Id
    @Column(name = "ROUTE_ID")
    private String routeId;

    @Id
    @Column(name = "STRT_DTE")
    private LocalDate startDate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ORDER")
    private Integer order;

    @Column(name = "END_DTE")
    private LocalDate endDate;
}