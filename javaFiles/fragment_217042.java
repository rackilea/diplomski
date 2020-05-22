public class Lane {
    private Road road;

    public Lane(Road road) {
        this.road = road;
    }

    public void go(){
        // Here you can call methods of Road
        road.switchLanes();
    }
}