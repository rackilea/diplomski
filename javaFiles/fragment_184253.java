try (Connection con = DriverManager.getConnection(this.url, this.username, this.password)) {
        PreparedStatement stm = con.prepareStatement("SELECT * FROM user WHERE username = ?");
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();
        if (rs.next() == false) {
            throw new Exceptions.UserNaoExiste();
        }
        u = new Entidades.User(rs.getString("Username"), rs.getString("Password"), rs.getString("Nick"), rs.getString("Admin"));
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }