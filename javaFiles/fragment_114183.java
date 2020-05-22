@Override
protected void onBeforeClusterRendered(Cluster<MyItem> cluster, MarkerOptions markerOptions)
{

    final Drawable clusterIcon = ContextCompat.getDrawable(MainActivity.context,R.drawable.[your_icon]);

    mClusterIconGenerator.setBackground(clusterIcon);

    //modify padding for one or two digit numbers
    if (cluster.getSize() < 10) {
        mClusterIconGenerator.setContentPadding(40, 20, 0, 0);
    }
    else 
    {
        mClusterIconGenerator.setContentPadding(30, 20, 0, 0);
    }

    Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster.getSize()));
    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));

}