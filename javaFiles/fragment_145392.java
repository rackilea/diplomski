stmt = con.prepareCall("{call insertEmployee(?,?,?,?,?,?)}");
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, role);
            stmt.setString(4, city);
            stmt.setString(5, country);