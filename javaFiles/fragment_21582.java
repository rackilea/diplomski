public class Pattern implements Serializable {
    @OneToOne(mappedBy = "pattern",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private File file;
}

public class File implements Serializable {
    @OneToOne(cascade=CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(unique = true)
    private Pattern pattern;
}