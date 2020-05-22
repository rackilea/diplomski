public class MyWidgetProvider extends AppWidgetProvider {
@Override
public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds) {
    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
    Intent configIntent = new Intent(context, MainActivity.class);
    configIntent.putExtra("widget",true);
    PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    remoteViews.setOnClickPendingIntent(R.id.message_button, configPendingIntent);
    appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
}
}