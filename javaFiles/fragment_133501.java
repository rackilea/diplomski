public class Place { 
    private Map containingMap;
    ...

    public boolean isSTartPlace() {
        return this.equals(containingMap.getStartPlace());
    }
}

public class Map{

    public void setStartPlace(Place p) {
        this.startPlace = p;
        p.setContainingMap(this);
    }
    ...
}