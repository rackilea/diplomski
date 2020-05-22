String strFilter = ParametriMetaData.PARAMETRO+"=?";
    ContentValues args = new ContentValues();
    args.put(ParametriMetaData.VALORE, valore);

    System.out.println( strFilter );

    mDb.update(ParametriMetaData.TAB_PARAMETRI, args, strFilter, parametro);