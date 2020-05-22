int p1Count = 0;
        int p2Count = 0;
        int BATCHSIZE = 1000;
        if (something) {
            try(PreparedStatement ps1 = con.prepareStatement(SQLContainer.SOME_SQL);
                   PreparedStatement ps2 = con.prepareStatement(SQLContainer.SOME_SQL2)) {                      
              for (Some some : someThing) {
                ps1.setString(1, some.name);
                ps1.setString(2, some.type);
                ps1.addBatch();
                if(++p1Count % BATCHSIZE == 0) {
                    ps1.executeBatch();
                }
                if (somethingElse) {
                    for (Some2 some2 : some.param) {
                        ps2.setString(1, some2.name);
                        ps2.setString(2, some2.value);
                        ps2.setString(3, some2.type);
                        ps2.addBatch();
                        if(++p2Count % BATCHSIZE == 0) {
                            ps2.executeBatch();
                        }
                    }
                }
              }
              p2.executeBatch();
              p1.executeBatch();
            } //End try-with-resource
        }