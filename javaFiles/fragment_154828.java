@Override
    public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "Market Billing Service Connected.");
            mService = IMarketBillingService.Stub.asInterface(service);
            BillingHelper.instantiateHelper(getBaseContext(), mService);
    }