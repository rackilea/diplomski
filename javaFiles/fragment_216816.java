public class Feature implements Serializable {
    @OneToMany(mappedBy="feature")
    private List<Multimedia> multimediaList;
    ...
}

public class Multimedia implements Serializable {
    @ManyToOne
    @JoinTable(name = "multimedia_feature",
            joinColumns = @JoinColumn(name = "multimedia_oid") ,
            inverseJoinColumns = @JoinColumn(name = "feature_oid"))
    private Feature feature;
    ...
}