@Override
protected void onCreate(Bundle savedInstanceState) {
    GetWarehouseSales gws = new GetWarehouseSales(MainActivity.this);
    gws.executeGWS();

}