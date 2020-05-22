PreparedStatement pr = (PreparedStatement) conx.prepareStatement(
                    "INSERT INTO `utilisateur` (idUser, nom, login, password, email, telephone, ville, profil, photo) VALUES (?,?,?,?,?,?,?,?,?)");

            pr.setString(1,"default");
            pr.setString(2, nom);
            pr.setString(3, login);
            pr.setString(4, password);
            pr.setString(5, email);
            pr.setInt(6, telephone);
            pr.setString(7, ville);
            pr.setString(8, profil);
            pr.setString(9, photo);

            pr.executeUpdate();
            pr.close();

            resp.sendRedirect("login");