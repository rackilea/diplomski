public class MyDragShadowBuilder extends View.DragShadowBuilder {

    @Override
    public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
        outShadowSize.set(1,1);
        outShadowTouchPoint.set(0,0);
    }
}