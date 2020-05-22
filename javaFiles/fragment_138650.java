@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case R.id.wifistate:
        final WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if(wifi.isWifiEnabled()){
            wifi.setWifiEnabled(false);
            Drawable drawable = getResources().getDrawable(R.drawable.off);
            item.setIcon(drawable);
        }else{
            Drawable drawable = getResources().getDrawable(R.drawable.on);
            item.setIcon(drawable);
            wifi.setWifiEnabled(true);
        }
        break;

    }
    return true;