public static TransferUtility getTransferUtility(Context context) {
    if (sTransferUtility == null) {
        sTransferUtility = new TransferUtility(getS3Client(context.getApplicationContext()),
                context.getApplicationContext());
    }
    return sTransferUtility;
}