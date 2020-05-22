Connection con = ...
ResultSet rs = ...

CachedRowSet rowset = new CachedRowSetImpl();
rowset.populate(rs);

con.close()