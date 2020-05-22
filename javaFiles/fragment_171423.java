@Entity
@Cacheable(true)
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) //Hibernate specific
public class Employee extends ProjectTeamMember {
    ...
    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "targetId.employeeId", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Target> targets = new HashSet<Target>();

    public Set<Target> getTargets() {
        return targets;
    }

    public void setTargets(Set<Target> targets) {
        this.targets = targets;
    }    
    ...
}