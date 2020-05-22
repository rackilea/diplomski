@Entity
class Job {
    @OneToOne
    @JoinColumns ({
        @JoinColumn(name="loadPointType", referencedColumnName = "type"),
        @JoinColumn(name="loadPointZip", referencedColumnName = "zipCode"),
        @JoinColumn(name="loadPointCust", referencedColumnName = "customerNumber")
    })
    private JobEndPoint loadPoint;
    // similarly for unloadPoint
    // other properties
}