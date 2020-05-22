@Entity
public class Station {

    private Integer id;

    private List<RouteAndStation> routeList = new ArrayList<RouteAndStation>();

    @Id
    public Integer getId() {
       return this.id;
    }

    @OneToMany(mappedBy="station")
    // DO YOU NEDD CASCADE ???
    @Cascade(SAVE_UPDATE)
    public List<RouteAndStation> getRouteList() {
        return this.routeList;
    }


}