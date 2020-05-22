String query = "DELETE FROM `Event` WHERE `eventName` ='"+eventName+"' LIMIT 1";

        try {
            Connection con = getConnection();
            Statement s = con.createStatement();

            s.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }