String query = "SELECT * FROM WAREHOUSE WHERE REF LIKE(?)" ;
PreparedStatement pstatement = con.prepareStatement(query,
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY);
pstatement.setString(1, "96-18");
ResultSet rs = pstatement.executeQuery();