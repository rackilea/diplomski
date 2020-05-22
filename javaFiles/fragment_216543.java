con = konekMoko.getCon();
ps = con.prepareStatement(searchQuery);
rs = ps.executeQuery(); <-- This is in the wrong order

ps.setString(1, uname);
ps.setString(2, pword);