if( isFirstRunWithSpinner ) { 
isFirstRunWithSpinner = false;
}else{
RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);

AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

switch (position) {
case 0:
    info.setTextSize(10.0f);
    views.setFloat(R.id.tvConfigInput, "setTextSize", 10);
    Log.v(TAG, "position 0 chosed");
    break;

   ...

   break;  
case 17:
    info.setTextSize(28.0f);
    views.setFloat(R.id.tvConfigInput, "setTextSize", 60);
   break;  
}

//update widget with spinner input
Log.v(TAG, "update size start");
appWidgetManager.updateAppWidget(mAppWidgetId, views);
Log.v(TAG, "update size over");
}