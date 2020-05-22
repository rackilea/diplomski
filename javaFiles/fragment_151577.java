@Entity
    @Table(name="access_level")
    public class AccessLevel {

        @Id
        @GeneratedValue
        private Integer id;
        @Column(name="role_id")
        private Integer  roleId;
        @Column(name="user_id")
        private Integer  userId;