try {
        if (startsWith != null && !startsWith.equals("")) {
            cur = contactHelper.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    projection,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                            + " like \"" + startsWith + "%\""
                            + " AND "
                            + ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                            + " IN (SELECT " + ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                            + " as name FROM view_data GROUP BY " +ContactsContract.CommonDataKinds.Phone.NUMBER + " HAVING COUNT(name)>1)",
                    null,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                            + " ASC");
        } else {
            cur = contactHelper.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    projection,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                            + " IN (SELECT " + ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                            + " as name FROM view_data GROUP BY " +ContactsContract.CommonDataKinds.Phone.NUMBER + " HAVING COUNT(name)>1)",
                    null,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                            + " ASC");
        }
        cur.moveToFirst();
    } catch (Exception e) {
        e.printStackTrace();
    }