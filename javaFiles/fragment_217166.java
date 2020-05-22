@Entity
public class Business {
    @Id
    private Long id;

    @OneToMany(mappedBy = "business")
    private Set<Branch> branches = new HashSet<>();
}

@Entity
public class City {
    @Id
    private Long id;

    @OneToMany(mappedBy = "city")
    private Set<Branch> branches = new HashSet<>();
}

@Entity
public class Branch {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}