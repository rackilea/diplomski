if (mes.equals("Control")) { 
    Intent intent = new Intent();
    intent.setAction(MainActivity.REFRESH_ACTIVITY);

    sendBroadcast(intent);
}