//my declaration
        public static String CALL_DIRECTION;
        public static String phoneNumber;

        else if (extraState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                                if (phoneNumber == null)
                                phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                                CALL_DIRECTION = "INCOMING";

    Intent myIntent = new Intent(context, RecordService.class);                 myIntent.putExtra("commandType",FixedContants.STATE_INCOMING_NUMBER);
                        myIntent.putExtra("phoneNumber",

 phoneNumber);
                    CALL_DIRECTION = "OUTGOING";