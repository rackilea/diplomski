@Entity
class ThePileOfShit {
    @Id
    private Long id;

    @my.audit.framework.Id
    private String anotherId;

    @JsonIgnore
    // just a front-end flag ignore
    private boolean flag;

    @Column
    // not a field but getter because of any-weird-issue-you-want-to-put-here
    public String getWeirdStuff() { ... }

    // Useless converters
    public ModelA getAsModelA() { ... }

    public ModelB getAsModelB() { ... }

    // etc
    // etc
}