@RooJavaBean
@RooToString
@RooJpaEntity
@Entity
public class Client {
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date created_on;
    private String name;
}