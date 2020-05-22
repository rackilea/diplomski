// Register an onClickListener
    Intent intent = new Intent(context, TrunkWidget.class);
    intent.setAction(clickAction);
    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

    //Set pendingIntent
    PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    remoteViews.setOnClickPendingIntent(R.id.my_btn, pendingIntent);
    appWidgetManager.updateAppWidget(appWidgetId, remoteViews);