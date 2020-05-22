private static boolean amIDead() {
    if (mService == null || mContext == null) {
        Log.e(TAG, "BillingHelper not fully instantiated");
        return true;
    } else {
        return false;
    }
}