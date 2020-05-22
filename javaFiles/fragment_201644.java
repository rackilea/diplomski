public class Project {
    private User changedBy;

    @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST,
               org.hibernate.annotations.CascadeType.REFRESH, org.hibernate.annotations.CascadeType.MERGE })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by")
    public User getChangedBy() {
        return this.changedBy;
    }
    [...]
}