ContentResolver resolver = context.getContentResolver();
Cursor cursor = resolver.query(Telephony.Sms.CONTENT_URI,
                null,
                "WHERE " + Telephony.TextBasedSmsColumns.READ + " = ? and "
                + Telephony.TextBaseSmsColumns.ADDRESS + "= ?"   ,
                new String[]{"false", "+1 555 555 1212"},
                Telephony.Sms.Conversations.DEFAULT_SORT_ORDER);