public WidgetDisplay(Context ctxt, Intent intent) 
    {
        this.ctxt=ctxt;
        appWidgetId=intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
                setImageinView(this.ctxt);
    }

private void setImageinView(Context context) {
//read sd card and store bitmap in  arrayListBitmap;
}

@Override
public RemoteViews getViewAt(int position) {
remoteView = new RemoteViews(ctxt.getPackageName(), R.layout.row);
    remoteView.setImageViewBitmap(R.id.image_photo1,arrayListBitmap.get(i));
}