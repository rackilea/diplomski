@OneToMany
@JoinTable(name = "person_contact", joinColumns =
        {
                @JoinColumn(name = "person_id", referencedColumnName = "id"),
        },
        inverseJoinColumns = {
                @JoinColumn(name = "contact_id", referencedColumnName = "id")
        })
private Set<ContactEntity> contacts;