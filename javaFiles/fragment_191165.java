@Override
public void onCreate() {




    String number = “12345678”


    StringBuffer sb = new StringBuffer();
    Cursor managedCursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
    int snumber = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
    int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
    int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
    int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
    List<String> callList = new ArrayList<String>();


    while (managedCursor.moveToNext()) {
        callList.add(number);
        String callDate = managedCursor.getString(date);
        callList.add(callDate);
        String callDuration = managedCursor.getString(duration);
        Date callDayTime = new Date(Long.valueOf(callDate));


        break;
    }
    String phNumber = number;
    callList.add(phNumber);
    String callType = managedCursor.getString(type);
    callList.add(callType);


            if (callList.contains(phNumber)) {

                    System.out.println("The phone number is " + phNumber );


                } else {

                    System.out.println(“Couldn’t find number ” + phNumber);


                }

            }

    }