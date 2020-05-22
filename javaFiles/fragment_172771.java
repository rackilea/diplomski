@SpringBootApplication
@EnableJpaAuditing
public class So45347635Application {
    public static void main(String[] args) { SpringApplication.run(So45347635Application.class, args); }

    @MappedSuperclass
    @EntityListeners(AuditingEntityListener.class)
    public static abstract class AbstractDomain extends AbstractPersistable<Long> implements Auditable<String, Long> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Version
        private int version;

        @Column(updatable = false)
        private String createdBy;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(updatable = false)
        private Date createdDate;

        private String lastModifiedBy;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(insertable = false)
        private Date lastModifiedDate;

        @Override
        public String getCreatedBy() {
            return this.createdBy;
        }

        @Override
        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        @Override
        public DateTime getCreatedDate() {
            return null == this.createdDate ? null : new DateTime(this.createdDate);
        }

        @Override
        public void setCreatedDate(DateTime createdDate) {
            this.createdDate = createdDate.toDate();
        }

        @Override
        public String getLastModifiedBy() {
            return this.lastModifiedBy;
        }

        @Override
        public void setLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
        }

        @Override
        public DateTime getLastModifiedDate() {
            return null == this.lastModifiedDate ? null : new DateTime(this.lastModifiedDate);
        }

        @Override
        public void setLastModifiedDate(DateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate.toDate();
        }
    }

    @Entity
    @Table(name = "users")
    public static class User extends AbstractDomain {
        private String username = "anonymous";

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return String.format("User{id=%d, createdBy='%s', createdDate=%s, lastModifiedBy='%s', lastModifiedDate=%s, username='%s'}",
                    getId(), getCreatedBy(), getCreatedDate(), getLastModifiedBy(), getLastModifiedDate(), username);
        }
    }

    @Bean
    AuditorAware auditor() { return () -> "system"; }

    @Bean
    CommandLineRunner start(UserRepository userRepository, TransactionTemplate tx) {
        return args -> tx.execute(ctx -> {
            final User user = userRepository.save(new User());
            user.setUsername("admin");
            System.out.println(">>>> " + userRepository.save(user));
            return null;
        });
    }
}

interface UserRepository extends CrudRepository<So45347635Application.User, Long> {
}