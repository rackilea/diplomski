con = konekMoko.getCon();
ps = con.prepareStatement(searchQuery);
ps.setString(1, uname);
ps.setString(2, pword);

rs = ps.executeQuery();