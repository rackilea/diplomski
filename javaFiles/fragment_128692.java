networkOk = NetworkHelper.hasNetworkAccess(this);
    if (networkOk) {
        Intent intent = new Intent(MainActivity.this, Myservice.class);
        intent.setData(Uri.parse(jsonurl));
        startService(intent);
    }