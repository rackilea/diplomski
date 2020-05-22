@Override
public void onReceive(Context context, Intent intent) {
  .....
  Bundle extras = intent.getExtras();
  int appWidgetId = extras.getExtra(AppWidgetManager.EXTRA_APPWIDGET_ID);
  .....
}