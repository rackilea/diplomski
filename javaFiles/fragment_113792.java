@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "MANAGED_APPLICATION_TO_CONTACT", schema = "UAM",
        joinColumns = {@JoinColumn(name = "CONTACT_ID",
                referencedColumnName = "CONTACT_ID",
                nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "MANAGED_APPLICATION_ID",
                referencedColumnName = "MANAGED_APPLICATION_ID",
                nullable = false)})
@OrderBy("name asc")
public Set<ManagedApplication> getManagedApplications() {
    return this.managedApplications;
}

public void setManagedApplications(final Set<ManagedApplication> managedApplications) {
    this.managedApplications = managedApplications;
}