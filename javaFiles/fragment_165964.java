String width = jFormattedTextField1.getText();
        String heigth = jFormattedTextField2.getText();
        PreparedStatement ps;
        if (width.equals("") && heigth.equals("")) {
            query = "select * from dbo.Table ";
            ps = conn.prepareStatement(query);
        } else if (width != null && !"".equals(width) && heigth != null && !"".equals(heigth)) {
            query = "select * from dbo.Table where width = ? and heigth = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, width);
            ps.setString(2, heigth);
        }