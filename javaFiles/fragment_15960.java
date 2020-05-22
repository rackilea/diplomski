@Override
public void onReceive(Context context, Intent intent) {
    super.onReceive(context, intent);
    if (NEXT_RECORD.equals(intent.getAction())) {
        mDbHelper = new DbHelper(context); // I guessed at the constructor's parameters
        newid = mDbHelper.getNextRecord(1, keyid);
    }

}