SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    ResultSet rs_dt = cmd1.executeQuery(dt);

    String time_stmp = null;

    while (rs_dt.next())
    {
       time_stmp = rs_dt.getString(1);
    }
    Date d = null;
    try {
       Date d = df.parse(time_stmp);
    } catch (ParseException ex) {
        Logger.getLogger(Prime.class.getName()).log(Level.SEVERE, null, ex);
    }
    SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddhhmmss");

    StringBuilder ts = new StringBuilder( df2.format(d) );