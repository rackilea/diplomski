@Override
public void onReceive(Context context, Intent intent) {
    views = new RemoteViews(context.getPackageName(),
                    R.layout.widget);
    AppWidgetManager mManager = AppWidgetManager.getInstance(context);
    ComponentName cn = new ComponentName(context,YourAppWidgetProvider.class);
    ...
    mManager.updateAppWidget(cn, views);

}