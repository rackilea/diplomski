@Override
public void onReceive(Context context, Intent intent) {
    AppWidgetManager widgetManager = AppWidgetManager.getInstance(getApplicationContext());
    int[] appWidgetIds = widgetManager.getAppWidgetIds(new ComponentName(context, BatteryWidget.class));

    Intent updateIntent = new Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE, null, getApplicationContext(), BatteryWidget.class);
    updateIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

    sendBroadcast(updateIntent);
}