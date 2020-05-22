@Transient
public Set<ManagedApplication> getManagedApplications() {
    if (this.managedApplications.isEmpty()) {
        this.managedApplications = this.managedApplicationToContacts.stream()
                .map(ManagedApplicationToContact::getManagedApplication)
                .collect(Collectors.toSet());
    }
    return this.managedApplications;
}