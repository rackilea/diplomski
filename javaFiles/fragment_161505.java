Monitor widgetMonitor = mTextWidget.getMonitor();
Rectangle monitorRect = widgetMonitor.getBounds();

if(monitorRect.x < 0){
   // shown in left monitor, starting from the main monitor
}

if(monitorRect.x > monitorRect.width){
   // shown in right monitor, starting from the main monitor
}