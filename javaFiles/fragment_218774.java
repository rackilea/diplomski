public class WorkLocationSuburb {
    @ManyToOne
    @JoinColumn
    private Dnar parentDnar;
    // ...
}

public class Dnar {
    @OneToMany(mappedBy = "parentDnar", ...)
    private Set<WorkLocationSuburb> suburbs;
    // ...
}