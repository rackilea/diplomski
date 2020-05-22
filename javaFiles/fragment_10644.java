int p1Count = 0;
    int BATCHSIZE = 1000;
    if (something) {
            PreparedStatement ps1 = con.prepareStatement(SQLContainer.SOME_SQL);        
            for (Some some : someThing) {
                ps1.setString(1, some.name);
                ps1.setString(2, some.type);
                ps1.addBatch();
                if(++p1Count % BATCHSIZE == 0) {
                    ps1.executeBatch();
                }
                ... 
            }
            ps1.executeBatch();