ContentProviderResult[] res;
    try
    {
        res = KramerApplication.getInstance().getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
        if (res != null && res[0] != null)
        {
            String uri = res[0].uri.getPath().substring(14);
            r.setBook_id( new Integer(uri).intValue() );
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }