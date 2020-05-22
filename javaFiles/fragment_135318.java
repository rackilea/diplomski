protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    TelephonyManager tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    String networkOperator = tel.getNetworkOperator();

    if (!TextUtils.isEmpty(networkOperator)) {
        int mcc = Integer.parseInt(networkOperator.substring(0, 3));
        int mnc = Integer.parseInt(networkOperator.substring(3));
    }
}