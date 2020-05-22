class Main {
    private final Runway[] runways = { new Runway(), new Runway() };

    void main(){
        for(int i=0; i<5; i++){
             System.out.println("Plane #" + i + " attempting to land.");
             Runway runway = runways.get(i%runways.length);
             runway.land(new Plane(i));
        }
    }
}
class Runway {
    public synchronized land(Plane plane){
        System.out.println(plane + " landed.");
    }
}