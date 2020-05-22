@Entity
public class RouteAndStation {

    private Route route;
    private Station station;

    private Integer stationNumber;

    private RouteAndStationId routeAndStationId;

    @EmbeddedId
    public RouteAndStationId getRouteAndStationId() {
        return this.routeAndStationId;
    }

    public void addStation(Route route, Station station, Integer stationNumber) {
        this.route = route;
        this.station = station;

        this.stationNumber = stationNumber;

        setRouteAndStationId(new RouteAndStationId(route.getId(), station.getId));
    }

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="ROUTE_ID", insertable=false, updateable=false)
    public Route getRoute() {
        return this.route;
    }

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="STATION_ID", insertable=false, updateable=false)
    public Station getStation() {
        return this.station;
    }

    @Embeddable
    public static class RouteAndStationId implements Serializable {

        private Integer routeId;
        private Integer stationId;

        // required no-arg constructor
        public RouteAndStationId() {}

        public RouteAndStationId(Integer routeId, Integer stationId) {
            this.routeId = routeId;
            this.stationId = stationId;
        }

        @Column(name="ROUTE_ID")
        public Integer getRouteId {
            return this.routeId;
        }

        @Column(name="STATION_ID")
        public Integer getStationId {
            return this.stationId;
        }

        public boolean equals(Object o) {
            if(o == null)
                return false;

            if(!(o instanceof RouteAndStationId))
                return false;

            RouteAndStationId other = (RouteAndStationId) o;
            if(!(getRouteId().equals(other.getRouteId())))
                return false;

            if(!(getStationId().equals(other.getStationId())))
                return false;

            return true;
        }

    }

}