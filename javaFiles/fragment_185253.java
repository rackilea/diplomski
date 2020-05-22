@OneToMany(mappedBy = "roleName", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List candidateProfiles;

    @OneToMany(mappedBy = "companyRoleName", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List recruiterDetails;