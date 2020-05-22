builder.setNeutralButton("Delete", new CommandWrapper(delete) {
    public void onClick(DialogInterface dialog, int which) {
        //do things
        cur.moveToFirst();
        while(cur.moveToNext()) {
            String tempLabel = cur.getString(cur.getColumnIndex(DbSchema.SiteSchema.COLUMN_LABEL));
            View selectedSiteView = siteSpn.getSelectedView();
            String label = ((TextView)selectedSiteView.findViewById(android.R.id.text1)).getText().toString();
            if(tempLabel.equals(label)) {
                mDb.delete(DbSchema.SiteSchema.TABLE_NAME, DbSchema.SiteSchema.COLUMN_LABEL+"=?", new String[] { label });
            }
        }
        dialog.dismiss();
        this.execute();
    }
});