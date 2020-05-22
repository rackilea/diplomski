public FunctionalityManager() {
    super();
    startDate = new Date();
    endDate = new Date();
    Leaders = new HashSet<Person>(); // Changed
    Reviewers = new HashSet<Person>(); // Changed
    SoftwareWorks = new ArrayList<SoftwareWork>(); // Changed
    HardwareWorks = new ArrayList<DiplomaWork>(); // Changed
    NetWorks = new ArrayList<DiplomaWork>(); // Changed
}