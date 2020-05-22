String formatIn = "dd-MMM-yyyy";
    SimpleDateFormat sdfi = new SimpleDateFormat(formatIn);
    java.util.Date inDate = sdfi.parse("29-Aug-2010");

    java.sql.Date sqlDate = new java.sql.Date(inDate.getTime());

    PreparedStatement prest = con
            .prepareStatement("INSERT INTO Charity (req_date) VALUES (?)");
    prest.setDate(1, sqlDate);
    int row = prest.executeUpdate();