/**
 * The {@link BillingReceiver} sends messages to this service using intents.
 * Each intent has an action and some extra arguments specific to that action.
 * @param intent the intent containing one of the supported actions
 * @param startId an identifier for the invocation instance of this service
 */
public void handleCommand(Intent intent, int startId) {
    String action = intent.getAction();
    if (Consts.DEBUG) {
        Log.i(TAG, "handleCommand() action: " + action);
    }
    if (Consts.ACTION_CONFIRM_NOTIFICATION.equals(action)) {
        String[] notifyIds = intent.getStringArrayExtra(Consts.NOTIFICATION_ID);
        confirmNotifications(startId, notifyIds);
    } else if (Consts.ACTION_GET_PURCHASE_INFORMATION.equals(action)) {
        String notifyId = intent.getStringExtra(Consts.NOTIFICATION_ID);
        getPurchaseInformation(startId, new String[] { notifyId });
    } else if (Consts.ACTION_PURCHASE_STATE_CHANGED.equals(action)) {
        String signedData = intent.getStringExtra(Consts.INAPP_SIGNED_DATA);
        String signature = intent.getStringExtra(Consts.INAPP_SIGNATURE);
        purchaseStateChanged(startId, signedData, signature);
    } else if (Consts.ACTION_RESPONSE_CODE.equals(action)) {
        long requestId = intent.getLongExtra(Consts.INAPP_REQUEST_ID, -1);
        int responseCodeIndex = intent.getIntExtra(Consts.INAPP_RESPONSE_CODE,
                ResponseCode.RESULT_ERROR.ordinal());
        ResponseCode responseCode = ResponseCode.valueOf(responseCodeIndex);
        checkResponseCode(requestId, responseCode);
    }
}