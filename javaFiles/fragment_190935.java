/**
 * This is called when Android Market sends information about a purchase state
 * change. The signedData parameter is a plaintext JSON string that is
 * signed by the server with the developer's private key. The signature
 * for the signed data is passed in the signature parameter.
 * @param context the context
 * @param signedData the (unencrypted) JSON string
 * @param signature the signature for the signedData
 */
private void purchaseStateChanged(Context context, String signedData, String signature) {
    Intent intent = new Intent(Consts.ACTION_PURCHASE_STATE_CHANGED);
    intent.setClass(context, BillingService.class);
    intent.putExtra(Consts.INAPP_SIGNED_DATA, signedData);
    intent.putExtra(Consts.INAPP_SIGNATURE, signature);
    context.startService(intent);
}