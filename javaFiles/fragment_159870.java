@Entity
@Table(name = "user_detail")
public class UserDetail {    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private User user;
}