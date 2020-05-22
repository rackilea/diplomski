@Entity
public class Skill {
    @Id
    @GeneratedValue
    @Column(name = "skillId")
    private long id;
    private String skill;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userSkillsList",
            joinColumns = {@JoinColumn(name = "skillId")},
            inverseJoinColumns = {@JoinColumn(name = "username")})
    private Set<User> skillOwners;

}