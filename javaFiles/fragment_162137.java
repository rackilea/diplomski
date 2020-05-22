// subscriptions we own
IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
    public void onQueryInventoryFinished(IabResult result,
            Inventory inventory) {
        if (result.isFailure()) {
            complain("Failed to query inventory: " + result);
            return;
        }

        mIsPremium = inventory.hasPurchase(SKU_PREMIUM); ------> By here you can get information 

    }
};