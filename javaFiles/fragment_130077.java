ActivityCompat.requestPermissions(MonySendActivity.this, new String[] { "android.permission.CALL_PHONE" }, 1);

        String str2 = roshanmoney.getText().toString();
        String str3 = roshannumber.getText().toString();
        String objectmoney;
        try {
            String str1 = URLEncoder.encode("#", "UTF-8");
            objectmoney = str1;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (;;) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }

        Intent i = new Intent(ACTION_CALL, Uri.parse("tel:*123*07" + str3 + "*" + str2 + objectmoney));
        startActivity(i);
        return ;
    }else {
        String str2 = roshanmoney.getText().toString();
        String str3 = roshannumber.getText().toString();
        String object;
        try {
            String str1 = URLEncoder.encode("#", "UTF-8");
            object = str1;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (;;) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }

        Intent i = new Intent(ACTION_CALL, Uri.parse("tel:*123*07"+ str3 + "*" + str2 + object));
        startActivity(i);

    }