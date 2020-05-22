Calendar now = Calendar.getIntance ();
 Calendar dt = Calendar.getIntance ();
 dt.setTime (date.getIme());

 int nowYear = now.get(Calendar.YEAR);
 int dtYear = dt.get(Calendar.YEAR);
 int nowDOY = now.get(Calendar.DAY_OF_YEAR);
 int dtDOY = dt.get(Calendar.DAY_OF_YEAR);

 // do comparison