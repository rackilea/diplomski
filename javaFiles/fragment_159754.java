public ArrayList<Receipt> searchReceipts(String query, DbAdapter _db, Cursor cursor)
{
    ArrayList<Receipt> receiptList = null;

    try
    {
        _db.open();

        if (cursor != null)
        {
            receiptList = buildReceiptList(cursor);
        }

        _db.close();
    }
    catch (SQLException e)
    {
        Log.d(context.getString(R.string.tag_receipttracker), e.getMessage());
        showToast(MESSAGE_COULD_NOT_OPEN);
    }

    return receiptList;
}