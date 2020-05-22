TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

Method m1 = tm.getClass().getDeclaredMethod("getITelephony");
m1.setAccessible(true);
Object iTelephony = m1.invoke(tm);

Method m3 = iTelephony.getClass().getDeclaredMethod("endCall"); 

m2.invoke(iTelephony);