/**
 * Verifies that the data was signed with the given signature, and calls
 * {@link ResponseHandler#purchaseResponse(Context, PurchaseState, String, String, long)}
 * for each verified purchase.
 * @param startId an identifier for the invocation instance of this service
 * @param signedData the signed JSON string (signed, not encrypted)
 * @param signature the signature for the data, signed with the private key
 */
private void purchaseStateChanged(int startId, String signedData, String signature) {
    ArrayList<Security.VerifiedPurchase> purchases;
    purchases = Security.verifyPurchase(signedData, signature);
    if (purchases == null) {
        return;
    }

    ArrayList<String> notifyList = new ArrayList<String>();
    for (VerifiedPurchase vp : purchases) {
        if (vp.notificationId != null) {
            notifyList.add(vp.notificationId);
        }
        ResponseHandler.purchaseResponse(this, vp.purchaseState, vp.productId,
                vp.orderId, vp.purchaseTime, vp.developerPayload);
    }
    if (!notifyList.isEmpty()) {
        String[] notifyIds = notifyList.toArray(new String[notifyList.size()]);
        confirmNotifications(startId, notifyIds);
    }
}