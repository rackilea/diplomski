public static synchronized String getPreferenceString(Context context, String key)
    {
        Cursor c = DatabaseHelper.getDatabase(context).query(TABLE_NAME, new String[] { "Value" }, "Key=?",
                new String[] { key }, null, null, null, null);

        if (c == null)
             return "";

        try {    
            return c.moveToFirst() ? c.getString(0) : "";
        } finally {
            c.close();
        }
    }