public class onRestartReciever extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {
    // TODO Auto-generated method stub
    Log.d("DEBUG", "onRestartReciever");

    // Register Services
    MyWidget_1x1.registerServices(context);
    MyWidget_2x2.registerServices(context);

    // reInitialize appWidgets
    AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(context);

    MyWidget_1x1 widget1x1=new CallWidgi();
    widget1x1.onUpdate
    (context,
         AppWidgetManager.getInstance(context),
            widget1x1.getIDs(context, appWidgetManager));

    MyWidget_2x2 widget2x2=new CallWidgi2();
    widget2x1.onUpdate(context,
                        AppWidgetManager.getInstance(context),
                            widget2x2.getIDs(context, appWidgetManager));
    }
}