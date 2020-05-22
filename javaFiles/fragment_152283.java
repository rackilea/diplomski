public class Hand implements Viewable<Hand, HandView> {
    @Override
    public void addViewCallback(HandView view) {}

    @Override
    public void removeViewCallback(HandView view) {}

}

public interface HandView extends View<Hand> {
}