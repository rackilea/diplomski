@Entity
public class Route {

    private Integer id;

    private List<RouteAndStation> stationList = new ArrayList<RouteAndStation>();

    @Id
    public Integer getId() {
        return this.id;
    }

    @OneToMany(mappedBy="route")
    @Cascade(SAVE_UPDATE)
    public List<RouteAndStation> getStationList() {
        return this.stationList;
    }

    @Transient
    public List<Station> getStationByOrderNumber() {
        Collections.sort(this.stationList, new Comparator<RouteAndStation>() {
            public int compare(RouteAndStation o1, RouteAndStation o2) {
                return o1.getOrderNumber().compareTo(o2.getOrderNumber());
            }
        });

        List<Station> sList = new ArrayList();
        for(RouteAndStation routeAndStation: this.stationList)
            sList.add(routeAndStation.getStation());

        return sList;
    }

    public void addStation(Station station) {
        RouteAndStation routeAndStation = new RouteAndStation();

        routeAndStation.addStation(this, station, getStationList().size());

        getStationList().add(routeAndStation);
    }

}