public Mapitems(Drawable defaultMarker) {
    super(boundCenterBottom(defaultMarker));
    mContext = android.content.getApplicationContext();
    // or: mContext = new Context();
}

public Mapitems(Drawable defaultMarker, Context context) {
    super(defaultMarker);
    if(context==null)
        mContext = android.content.getApplicationContext();
        // or: mContext = new Context();
    mContext = context;
}