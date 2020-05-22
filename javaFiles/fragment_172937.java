// The types specified here are the input data type, the progress type, and the result type
private class MyAsyncTask extends AsyncTask<String, Void, String> {
     protected void onPreExecute() {
         // Runs on the UI thread before doInBackground
         // Good for toggling visibility of a progress indicator
         progressBar.setVisibility(ProgressBar.VISIBLE);
     }

     protected Bitmap doInBackground(String... strings) {
          String menuListSTR = "";
    if (MenuActivity.Prst_ID.trim() == "-1") 
        menuListSTR = "Select ID,Code,Name,Name2 From Presets Where Active = 1 And Rest_ID_Active = 1 AND OutLet_ID_Active = 1 ORDER BY Code";
    else 
        menuListSTR = "select dbo.MenuItems.Item_ID, dbo.Items.Code, dbo.Items.Name, dbo.Items.Name2, dbo.Items.PrintOnChick, dbo.Items.Taxable, dbo.Items.NoServiceCharge, dbo.Items.PrintOnReport,Case { fn IFNULL ((SELECT Price_Value FROM dbo.ItemsPrices WHERE (PriceLVL_ID = 1) AND (Item_ID = dbo.Items.ID)), 0) } when 0 then dbo.Items.StaticPrice Else { fn IFNULL ((SELECT Price_Value FROM dbo.ItemsPrices WHERE (PriceLVL_ID = 1) AND (Item_ID = dbo.Items.ID)), dbo.Items.StaticPrice) } END AS Price From dbo.MenuItems LEFT OUTER JOIN dbo.Items ON dbo.MenuItems.Item_ID = dbo.Items.ID Where  (dbo.MenuItems.Preset_ID = " + MenuActivity.Prst_ID + ") AND (dbo.MenuItems.Rest_ID_Active = " + ConnectionClass.Rest_ID + ") AND (dbo.MenuItems.OutLet_ID_Active = " + ConnectionClass.OutletID + ") AND (dbo.Items.Active = 1) ORDER BY dbo.MenuItems.SortNumber";

    ResultSet rs = ConnectionClass.Ret_RS(menuListSTR);
    try { 
        while (rs.next()) {
            SortedMap<String, String> sm = new TreeMap<String, String>();
            sm.put("Item_ID", rs.getString("Item_ID"));
            sm.put("Name", rs.getString("Name"));
            sm.put("Price", rs.getString("Price"));
            sm.put("PrintOnChick", rs.getString("PrintOnChick"));
            sm.put("Taxable", rs.getString("Taxable"));
            sm.put("NoServiceCharge", rs.getString("NoServiceCharge"));
            sm.put("PrintOnReport", rs.getString("PrintOnReport"));
            if (TablesFragment.Check_Items.containsKey(rs.getString("Item_ID"))) {
                SortedMap<String, String> sm1 = TablesFragment.Check_Items.get(rs.getString("Item_ID"));
                sm.put("Qty", sm1.get("Qty"));
            } else 
                sm.put("Qty", "0");
            alphabets.add(sm);
            listMenuArray.add(rs.getString("Name"));

        } 
    } catch (SQLException e) {
        e.printStackTrace();
    }  
         return someBitmap;
     }

     protected void onProgressUpdate(Progress... values) {
        // Executes whenever publishProgress is called from doInBackground
        // Used to update the progress indicator
        progressBar.setProgress(values[0]);
     }  

     protected void onPostExecute(Bitmap result) {
         // This method is executed in the UIThread
         // with access to the result of the long running task
           menuListView.setAdapter(new CustomMenuLVAdapter(this, listMenuArray, alphabets));
         // Hide the progress bar
         progressBar.setVisibility(ProgressBar.INVISIBLE);
     }
}