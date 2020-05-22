PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) FROM attendance where sub_id=? and reg_no=?");
        for (int i = 0; i < (k - 1); i++) {
            statement.setString(1, sub);
            statement.setString(2, reg_no);
            ResultSet rs3 = ps3.executeQuery();
            rs3.next();
            t_class[k] = rs3.getInt(1);
        }