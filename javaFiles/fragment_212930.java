int counter = 0;
            for(int i=0;i<=1;i++){
                List resTimeArraySms=new ArrayList();
               resultCursorSMS = NTDBHelper.getInstance().getResultDataByMediaType(getApplicationContext(), "Plan1",1);

               while (resultCursorSMS.moveToNext()){

                   HashMap resHash=new HashMap();
                   resTimeStampSms = resultCursorSMS.getLong(resultCursorSMS.getColumnIndex(NTDataProvider.KEY_RESULTS_TIME_STAMP));
                   resHash.put("timestampsms"+counter, resTimeStampSms);
                   resTimeArraySms.add(resHash);
                   counter++;
               } 



            resTimeArray.add(resTimeArraySms);
           }