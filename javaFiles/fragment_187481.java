package forum13318677;

public class Factory {

    public TopNoControlClass createTopNoControlClass() {
        return new TopNoControlClass(null);
    }

    public BottomNoControlClass createBottomNoControlClass() {
        return new BottomNoControlClass(null);
    }

}