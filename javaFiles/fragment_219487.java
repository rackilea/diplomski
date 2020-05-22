public class MyRenderer extends DefaultClusterRenderer<MyItem> {

    public MyRenderer(Context context, GoogleMap map, ClusterManager<MyItem> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onClusterItemRendered(MyItem clusterItem,
                                         Marker marker) {
        super.onClusterItemRendered(clusterItem, marker);

        //other stuff......
    }
}