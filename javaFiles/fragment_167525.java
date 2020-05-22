public class VpnWidgetProvider extends AppWidgetProvider {
public static String ACTION_WIDGET_REFRESH = "ActionReceiverRefresh";
//your code here...
@Override
public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//you code here...

Intent intent = new Intent(context, VpnWidgetProvider.class);
intent.setAction(appWidgetManager.ACTION_WIDGET_REFRESH);//get action here
//you code here...