public class TestWidget extends AppWidgetProvider {

  public static String REFRESH_ACTION = "android.appwidget.action.APPWIDGET_UPDATE";
  static private RemoteViews views;
  private int x = 0;

   @Override
    public void onReceive(Context context, Intent intent) {
    super.onReceive(context, intent);

    if (intent.getAction().equalsIgnoreCase(REFRESH_ACTION)) {
      views = new RemoteViews(context.getPackageName(), R.layout.test_widget);
      AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
      int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, TestWidget.class));
      x++;
      views.setTextViewText(R.id.textv_count, x + "");
      appWidgetManager.updateAppWidget(appWidgetIds, views);
    }
  }

   static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

    views = new RemoteViews(context.getPackageName(), R.layout.test_widget); 
    views.setTextViewText(R.id.textv_count, x + "");
    views.setOnClickPendingIntent(R.id.button, getPenIntent(context));
    appWidgetManager.updateAppWidget(appWidgetId, views);
  }



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
     for (int appWidgetId : appWidgetIds) {
      appWidgetManager.updateAppWidget(appWidgetId, views);
    }
  }

    static private PendingIntent getPenIntent(Context context) {
    Intent intent = new Intent(context, TestWidget.class);
    intent.setAction(REFRESH_ACTION);
    return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
  }

}