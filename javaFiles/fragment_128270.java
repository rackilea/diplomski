private void initListView()
{
    final String   AuthorName    = "Author: ";
    final String   CopyrightName = "CopyRight: ";
    final String   PriceName     = "Price: ";

    final String[] matrix  = { "_id", "name", "value" };
    final String[] columns = { "name", "value" };
    final int[]    layouts = { android.R.id.text1, android.R.id.text2 };

    MatrixCursor  cursor = new MatrixCursor(matrix);

    DecimalFormat formatter = new DecimalFormat("##,##0.00");

    cursor.addRow(new Object[] { key++, AuthorName, mAuthor });
    cursor.addRow(new Object[] { key++, CopyrightName, mCopyright });
    cursor.addRow(new Object[] { key++, PriceName,
            "$" + formatter.format(mPrice) });

    SimpleCursorAdapter data =
        new SimpleCursorAdapter(this,
                R.layout.viewlist_two_items,
                cursor,
                columns,
                layouts);

    setListAdapter( data );

}   // end of initListView()