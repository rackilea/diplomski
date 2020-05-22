@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RouteEntityPk implements Serializable {

    private static final long serialVersionUID = 1L;

    private String routeId;
    private LocalDate startDate;
}