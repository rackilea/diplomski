@OneToMany(mappedBy = "roleName", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonBackReference(value="candidate-profiles")
    private List candidateProfiles;

    @OneToMany(mappedBy = "companyRoleName", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonBackReference(value="recruiter-details")
    private List recruiterDetails;